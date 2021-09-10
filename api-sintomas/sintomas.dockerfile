FROM node:14
ENV NODE_ENV=development
COPY ./api-sintomas /api-sintomas
WORKDIR /api-sintomas
RUN npm install
ENTRYPOINT ["npm", "run-script","dev:server"]
EXPOSE 3333