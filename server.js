const express=require('express')
const mongoose=require('mongoose')
const donutRouter = require('./routes/donutsRouter')
const app=express()

app.set('view engine','ejs')
app.set('views','views');



//connect to mongodb
const dbURI='mongodb+srv://layan:layan123@cluster0.rwvi2.mongodb.net/Donutsland?retryWrites=true&w=majority';

mongoose.connect(dbURI,{useNewUrlParser:true,useUnifiedTopology:true})
    .then((result)=>app.listen(3001))
    .catch((err)=>console.log(err))





    //to be able to use the css file in the public folder
app.use(express.static("public"));

//parser
app.use(express.urlencoded({ extended: true }))
app.get('/',(req,res)=>{
    res.render('mainpage' , {title : 'Main Page'});
});

// app.get('/add-user',(req,res)=>{

//     const user = new User({
//         username : "Layanw",
//         email : "layanwaleed@hotmail.com",
//         password: " Layanw20180193",
//         phone:'0790661780'
//     });

//     user.save()
//         .then((result)=>{
//             res.send(result);
//         })
//         .catch((err)=>{
//             console.log(err);
//         })

// })


// app.get('/add-admin',(req,res)=>{

//     const admin = new Admin({
//         username : "Raneem",
//         password: "raneem123",
//     });

//     admin.save()
//         .then((result)=>{
//             res.send(result);
//         })
//         .catch((err)=>{
//             console.log(err);
//         })

// })


// app.get('/add-orders',(req,res)=>{

//     const order = new Orders({
//         orderby:"Layanw",
//         chocolate:'2',
//         vanilla:'1',
//         sugared:'2',
//         plain:'1',
//         nutella:'1'
//     });

//     order.save()
//         .then((result)=>{
//             res.send(result);
//         })
//         .catch((err)=>{
//             console.log(err);
//         })

// })




app.use(donutRouter)

