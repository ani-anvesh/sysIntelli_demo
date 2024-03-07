// const IP_ADDRESS = "192.168.1.245";
const IP_ADDRESS_LOCAL = "localhost";
const PORT = "8080";
const URL = "http://" + IP_ADDRESS_LOCAL + ":" + PORT;
const axios = require("axios");

const instance = axios.create({
  baseURL: URL,
  timeout: 5000,
  headers: {
    "Content-Type": "application/json",
  },
});

module.exports = instance;
