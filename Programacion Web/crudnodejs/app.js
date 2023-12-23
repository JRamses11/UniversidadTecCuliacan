var express = require("express");
var mysql = require("mysql");
var app = express(); // EJECTUTAMOS EL SERIVIDOR

//HABILIRAR RECEPCION JSON
app.use(express.json());

// ENCENDER EL SERVIDOR
app.listen("3000", function(){
    console.log("Servidor puerto 3000")
});

// CONFIGURAMOS LA CONEXION
var conexion = mysql.createConnection({
    host: 'localhost',
    user: 'root',
    password: '',
    database: 'pw1213'
});

// PROBAR LA CONEXION
conexion.connect(function(error){
    if(error){
        throw error;
    }
    else{
        console.log("Conectado a la base de datos")
    }
});

const cors=require("cors");
const corsOptions ={
origin:'*', 
credentials:true, 
optionSuccessStatus:200,
}
app.use(cors(corsOptions))

app.get("/", function(req, res){ // PETICION --> RESPUESTA
    res.send("<h1>Ruta de inicio<h1>")
})

// VERBOS DE SOLICITUD DEL CLIENTE
// app.get();
// app.post();
// app.put();
// app.delete();

// MOSTRAR A LOS MAESTROS
app.get('/api/maestros', (req, res) => {
    conexion.query("SELECT * FROM maestros", (error, filas) =>{
        if (error){
            throw error;
        }
        else{
            res.header("Access-Control-Allow-Origin","*");
            res.send(filas);
        }
    });
})

// MOSTRAR SOLO UNN MAESTRO
app.get('/api/maestros/:id', (req, res) => {
    // eficiente para que no recorra toda la tabla
    conexion.query("SELECT * FROM maestros WHERE clave = ? LIMIT 1", [req.params.id], (error, fila) => { 
        if (error){
            throw error;
        }else{
            res.send(fila);
        }
    })
})

//AGREGAR UN MAESTRO
app.post("/api/maestros", (req, res)=>{
    let datos={
        clave: req.body.cla,
        nombre: req.body.nom,
        departamento: req.body.dep,
        estatus: req.body.est
    }
    let sql="INSERT INTO maestros SET ?"
    conexion.query(sql, datos, function(error, results){
        if(error){
            throw error;
        }else{
            res.send(results);
        }
    })
})

//ACTUALIZAR DATOS DE MAESTROS
app.put("/api/maestros/:id", (req, res)=>{
    let clave= req.params.id;
    let nombre= req.body.nom;
    let departamento= req.body.dep;
    let estatus= req.body.est;
    let sql="UPDATE maestros SET nombre=?, departamento=?, estatus=? WHERE clave=?"
    conexion.query(sql, [nombre, departamento, estatus, clave], function(error,results){
        if(error){
            throw error;
        }else{
            res.send(results);
        }
    })
})

//ELIMINAR UN RESGISTRO DE MAESTRO
app.delete("/api/maestros/:id", (req, res)=>{
    conexion.query("DELETE FROM maestros WHERE clave=?", [req.params.id], function(error, filas){
        if(error){
            throw error;
        }else{
            res.send(filas);
        }
    })
})