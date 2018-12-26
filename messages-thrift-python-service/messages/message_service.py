# coding: utf-8
from messages.api import MessagesService
from thrift.transport import TSocket
from thrift.transport import TTransport
from thrift.protocol import TBinaryProtocol
from thrift.server import TServer

import smtplib
from email.mime.text import MIMEText
from email.header import Header

sender = 'jizhe0910@163.com'
authCode = 'test01'
class MessagesServiceHandler:

    def sendMoblieMessage(self, mobile, messages):
        print('sendMobileMessages，moblie:' + mobile + ', messages:' + messages)
        return True

    def sendEmailMessages(self, email, messages):
        print ("sendEmailMessage, email:" + email +", messages:" + messages)
        messageObj = MIMEText(messages, "plain", "utf-8")
        messageObj['From'] = sender
        messageObj['To'] = email
        messageObj['Subject'] = Header('无主题', 'utf-8')
        try:
            smtpObj = smtplib.SMTP('smtp.163.com')
            smtpObj.login(sender, authCode)
            smtpObj.sendmail(sender, [email], messageObj.as_string())
            print ("send mail success")
            return True
        except smtplib.SMTPException:
            print ("send mail failed!")
            return False

if __name__ == '__main__':
    handler = MessagesServiceHandler()
    processor = MessagesService.Processor(handler)
    transport = TSocket.TServerSocket(None, "9090")
    tfactory = TTransport.TFramedTransportFactory()
    pfactory = TBinaryProtocol.TBinaryProtocolFactory()

    server = TServer.TSimpleServer(processor, transport, tfactory, pfactory)
    print ("python thrift server start")
    server.serve()
    print ("python thrift server exit")
