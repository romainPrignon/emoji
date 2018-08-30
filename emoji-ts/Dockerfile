FROM node:8

WORKDIR /opt

COPY package.json package.json
COPY tsconfig.json tsconfig.json

RUN npm install

CMD ["npm", "start"]