const pool = require('../domain/db.js');

module.exports = (app) => {
  
  app.post('/api/mobsite/register', (req, res) => {
    const post = {
     pwd: req.body.pwd,
     name: req.body.name,
     email: req.body.email,
     phone: req.body.phone
   }
    const queryString = 'insert into register set ?';
    console.log('got into server;;;');
    pool.query(queryString, post, (error, rows) => {
      if(error) {
        console.log("error");
        res.json(error);
      }
      else {
       // console.log(rows);
        const rowData = rows.insertId;
        pool.query('select * from register where id = ?', [rowData], (error, result) => {
          if(error){
            res.send(error);
          }
          else {
            console.log(result[0]);
            //res.json(result[0]);
            res.json({'response':"Registeration done"});
          }
        });
      }
    });
  });
   
  
  
};