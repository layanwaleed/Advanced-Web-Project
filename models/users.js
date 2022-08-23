const mongoose = require('mongoose');
const Schema = mongoose.Schema;

const Usersschema = new Schema({
    username : {
        type : String,
        required: [true,'Username is Required'],
        unique:true
    },
    email : {
        type : String,
        required:[true,'Email is Required'],
        unique:true,
        validate: {
            validator: function(v) {
                return /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(v);
            },
            message: "Please enter a valid email"
        }

    },

    password : {
        type : String,
        required:[true,'Password is Required'],
        // validate: {
        //     validator: function(v) {
        //         return /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$/.test(v);
        //     },
        //     message: "Please enter a valid password"
        // },
    },
    phone : {
        type : Number,
        required:[true,'Phone Number is required']
    }
});


const User = mongoose.model("Users", Usersschema);
module.exports=User;