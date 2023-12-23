<template>
     <div class="Editar">
        <h2>Datos del maestro</h2>
        <br>
        <label for="txtNombre">Nombre del maestro</label>
        <input type="text" 
        name="txtNombre" 
        id="txtNombre" 
        v-model="maestros.Nombre" 
        class="form-control"
        />
        <br>
        <label for="txtDepartamento">Nombre del departamento</label>
        <input type="text" 
        name="txtDepartamento" 
        id="txtDepartamento" 
        v-model="maestros.Departamento" 
        class="form-control"
        />
        <br>
        <label for="txtEstatus">Nombre del Estatus</label>
        <input type="text" 
        name="txtEstatus" 
        id="txtEstatus" 
        v-model="maestros.Estatus" 
        class="form-control"
        />
        <br>
     <button @click.prevent="actualizar()">Actualizar maestro</button>
     </div>
</template>


<script>
import {URL_DATOS} from "../utils/constantes";
import axios from "axios";


export default{
    name: "Detalle",
    components:{},
    props:{
        Clave: Number,
    },
    data: function(){
        return {
            maestros: [],
        };
    },
    created(){
        this.traeDetalle();
    },
    methods: {
        traeDetalle: async function(){
                let m=[];
                await axios.get(URL_DATOS+"/maestros/" + this.Clave).then(function(response){
                    console.log(response.data);
                    m=response.data[0];
                })
                this.maestros=m;
        },
        actualizar: async function(){
            const res= await axios.put(URL_DATOS+"/maestros/"+this.Clave,{
                Nombre: this.maestros.Nombre,
                Departamento: this.maestros.Departamento,
                Estatus: this.maestros.Estatus,
            })
            console.log(res);
        }
    },
}
</script>