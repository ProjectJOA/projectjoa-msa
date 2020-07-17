FROM nginx:1.14.2

ENV PATH /usr/local/bin:/usr/sbin:/sbin:$PATH

RUN apt-get update && \
    apt-get install -y curl && \
    rm -rf /var/lib/apt/lists/*

RUN rm -rf /usr/share/nginx/html/pro_test.html
RUN curl -o /usr/share/nginx/html/pro_test.html https://raw.githubusercontent.com/ProjectJOA/projectjoa-msa/master/projectjoa-web/pro_test.html

# Expose
EXPOSE 80

#ENTRYPOINT /usr/sbin/nginx