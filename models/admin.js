const mongoose = require('mongoose');
const Schema = mongoose.Schema;

const Adminsschema = new Schema({
    username:{
        type:String,
        required:true
    },
    password : {
        type:String,
        required:true
    }
});


const Admin = mongoose.model("Admin",Adminsschema);
module.exports=Admin;