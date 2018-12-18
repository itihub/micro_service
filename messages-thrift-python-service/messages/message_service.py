from messages.api import MessagesService


class MessagesServiceHandler:

    def sendMoblieMessage(self, mobile, messages):
        print('sendMobileMessages')
        return True

    def sendEmailMessages(self, email, messages):
        print('sendEmailMessages')
        return True

if __name__ == '__main__':
    handler = MessagesServiceHandler()
    processor = MessagesService.Processor(handler)
    TSocket.Tser