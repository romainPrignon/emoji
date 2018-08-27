FROM composer:1.7

WORKDIR /opt

COPY composer.json composer.json

RUN composer install

CMD ["composer", "run", "start"]