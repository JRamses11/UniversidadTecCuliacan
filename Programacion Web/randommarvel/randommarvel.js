var numero=0;
var personaje="";
var datos=[];

async function apimarvel(){
    numero=0;
    personaje=document.getElementById("txtpersonaje").value;
    const respuesta=await fetch("https://gateway.marvel.com/v1/public/characters?ts=1&apikey=67788e74df746a1523d8ebb504ee1008&hash=cf5ec9bfa5a156f031a69417cd0e012c&nameStartsWith="+personaje);
    datos=await respuesta.json();
    muestra();
}

function muestra(){
    let foto=document.getElementById("foto");
    let nombre=document.getElementById("nombre");
    let descripcion=document.getElementById("descripcion");
    let comicsDis=document.getElementById("comicsDis");

    foto.setAttribute('src', datos.data.results[numero].thumbnail.path+'.jpg');    nombre.innerHTML= datos.data.results[numero].name;
    descripcion.innerHTML=datos.data.results[numero].description;
    comicsDis.innerHTML=datos.data.results[numero].comics.available;
}