<template>
    <div class="maestrosLista">
        Hola maestros
        <br>
        <button @click="nuevoMaestro()">Nuevo</button>
        <table>
        <thead>
            <th>Clave</th>
            <th>Nombre</th>
            <th>Departamento</th>
            <th>Estatus</th>
            <th>Acciones</th>
        </thead>
        <tbody>
            <tr v-for="maestro in maestros" :key="maestro.Clave">
                <td>
                    <a href="" @click.prevent="detalleMaestro(maestro.Clave)">{{ maestro.Clave }}</a>
                </td>
                <td>{{ maestro.Nombre }}</td>
                <td>{{ maestro.Departamento }}</td>
                <td>{{ maestro.Estatus }}</td>
                <td>
                    <button @click.prevent="editarMaestro(maestro.Clave)">Editar</button>
                    <button @click.prevent="eliminarMaestro(maestro.Clave)">Eliminar</button>
                </td>
            </tr>
        </tbody>
    </table>
    </div>
</template>

<script>
import axios from "axios";
import {URL_DATOS} from "../utils/constantes"
export default {
        name: 'MaestrosLista',
        data() { //TODAS LAS VARIABLE SE PUEDEN USAR EN LA PLANTILLA-HTML
            return {
                maestros:[]
            }
        },
        created() {
            this.traeMaestros();
        },
        methods: { //LAS VARIABLES DECLRADAS EN DATA TIENEN QUE ASIGANARSE A UNA VARIABLE LOCAL EN AXIOS PORQUE ASI LE GUSTA ???????
            traeMaestros: async function(){
                let m=[];
                await axios.get(URL_DATOS+"/maestros").then(function(response){
                    m=response.data;
                })
                this.maestros=m;
            },
            detalleMaestro: function(Clave){
                this.$router.push({name:"detalle", params:{ Clave: Clave} });
            },

            editarMaestro: function(Clave){
                this.$router.push({name:"editar", params:{ Clave: Clave} });
            },

            eliminarMaestro: async function(Clave){
                const res= await axios.delete(URL_DATOS+"/maestros/"+Clave);
                this.traeMaestros();
                console.log(res);
            },

            nuevoMaestro: function(){
                this.$router.push({name:"nuevo", params:{} });
            }

        }

}

</script>
