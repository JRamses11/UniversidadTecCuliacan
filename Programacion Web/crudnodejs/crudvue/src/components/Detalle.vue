<template> 
    <div class="Detalle">
       Maestro numero: {{ Clave }}
       <br>
       Nombre:  {{ maestros.Nombre }}
       <br>
       Departamento: {{ maestros.Departamento }}
       <br>
       Estatus: {{ maestros.Estatus }}
       <br>
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
    },
}
</script>
