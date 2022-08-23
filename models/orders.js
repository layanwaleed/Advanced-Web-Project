const mongoose = require('mongoose');
const Schema = mongoose.Schema;

const Ordersschema = new Schema({

    orderby:{
        type:String
    },

    chocolate:{
        type:Number,
        min:0,
        max:10
    },
    vanilla:{
        type:Number,
        min:0,
        max:10
    },
    sugared:{
        type:Number,
        min:0,
        max:10
    },
    plain:{
        type:Number,
        min:0,
        max:10
    },
    nutella:{
        type:Number,
        min:0,
        max:10
    },
    phone:{
        type:Number
    }

},{timestamps:true});


const Order = mongoose.model('Order',Ordersschema);
module.exports=Order;