FROM python:3.7.8

RUN apt-get update && \
    apt-get upgrade -y && \
    apt-get install -y curl && \
    rm -rf /var/lib/apt/lists/*

RUN pip install --upgrade pip && pip install Django mysqlclient py-eureka-client

RUN curl -o pyserviceb.tar https://raw.githubusercontent.com/ProjectJOA/projectjoa-msa/master/libs/pyserviceb.tar

RUN tar -xvf pyserviceb.tar

#RUN cp -R /data/pyserviceb /
#RUN pip install --upgrade pip && pip install -r /pyserviceb/requirements.txt

# Expose
EXPOSE 9094

ENTRYPOINT python /pyserviceb/manage.py runserver 0.0.0.0:9094 --noreload