namespace java com.xxx.thrift.messages
namespace py messages.api

service MessagesService{

    bool sendMoblieMessage(1:string mobile, 2:string messages);

    bool sendEmailMessages(1:string email, 2:string messages);

}