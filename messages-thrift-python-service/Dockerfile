FROM python-base:latest
MAINTAINER jizhe@live.cn

#设置环境变量
ENV PYTHONPATH /
COPY message /message

ENTRYPOINT ["python", "/message/message_service.py"]