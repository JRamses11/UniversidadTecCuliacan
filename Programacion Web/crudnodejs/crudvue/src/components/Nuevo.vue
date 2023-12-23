<template>
    <div class="Nuevo">
        <h2>Datos del maestro -nuevo</h2>
        <!-- <br>
        <label for="txtClave">Clave del maestro</label>
        <input type="text" 
        name="txtClave" 
        id="txtNombre" 
        v-model="maestros.Clave" 
        class="form-control"
        /> -->
        <br>
        <label for="txtNombre">Nombre del maestro</label>
        <input type="text" 
        name="txtNombre" 
        id="txtNombre" 
        v-model="maestros.Nombre" 
        />
        <br>
        <label for="txtDepartamento">Nombre del departamento</label>
        <input type="text" 
        name="txtDepartamento" 
        id="txtDepartamento" 
        v-model="maestros.Departamento" 
        />
        <br>
        <label for="txtEstatus">Nombre del Estatus</label>
        <input type="text" 
        name="txtEstatus" 
        id="txtEstatus" 
        v-model="maestros.Estatus" 
        />
        <br>
        <button @click.prevent="nuevo()">Nuevo maestro</button>
    </div>
</template>

<script>
import {URL_DATOS} from "../utils/constantes";
import axios from "axios";

    export default {
        name: 'Nuevo',
        components: {  },
        data() {
            return {
                maestros:[],
            }
        },
        methods: {
            nuevo: async function(){
                const res= await axios.post(URL_DATOS+"/maestros",{
                Nombre: this.maestros.Nombre,
                Departamento: this.maestros.Departamento,
                Estatus: this.maestros.Estatus
            })
            console.log(res);
            },
        },
    }
</script>