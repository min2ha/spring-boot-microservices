FROM fluent/fluentd:v1.9-1
LABEL description="Install fluentd elasticsearch,loki plugin"
USER root
RUN apk add --update --virtual .build-deps \
    sudo build-base ruby-dev \
 && sudo gem install fluent-plugin-elasticsearch \
 && sudo gem install fluent-plugin-grafana-loki-licence-fix \
 && sudo gem sources --clear-all \
 && apk del .build-deps \
 && rm -rf /var/cache/apk/* \
           /home/fluent/.gem/ruby/2.4.0/cache/*.gem
