'use strict'
const express = require('express');
const app = express();
const port = process.env.PORT || 3000;
const bodyParser = require('body-parser');

const reg = require('./controller/register.js');

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended: true}));

reg(app);

app.get('/',(req, res) => {
  res.send('testing android app');
});
app.listen(port,() => {
  console.log(`listening on port ${port}`);
});