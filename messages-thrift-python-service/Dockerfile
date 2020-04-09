FROM python-base:latest
MAINTAINER jizhe jizhe@live.cn

#设置环境变量
ENV PYTHONPATH /
COPY messages /messages

ENTRYPOINT ["python", "/messages/message_service.py"]
