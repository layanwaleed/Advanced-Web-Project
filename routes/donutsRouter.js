const express = require("express");
const router = express.Router();
const User = require('../models/users')
const Admin = require('../models/admin')
const Order = require('../models/orders')
const formidable = require("formidable")
const fs = require('fs');
const path = require('path')
router.use(express.static("public"));





router.delete('/adminorders/:id',(req,res)=>{
    const id = req.params.id;
    Order.findByIdAndDelete(id)
    .then(result=>{
        res.json({redirect : '/adminorders'})
    })
})



router.delete('/adminusers/:id',(req,res)=>{
    const id = req.params.id;
    User.findByIdAndDelete(id)
    .then(result=>{
        res.json({redirect : '/adminusers'})
    })
})



router.get('/home',(req,res)=>{
    res.render('homepage' , {title : 'Home Page'});
});



router.get('/signin',(req,res)=>{
    res.render('signin' , {title : 'Sign In'});
});



router.get('/signup',(req,res)=>{
    res.render('signup' , {title : 'Sign Up'});
});




router.get('/adminsignin',(req,res)=>{
    res.render('adminsignin' , {title : 'Sign In'});
});


router.get('/aboutus',(req,res)=>{
    res.render('aboutus' , {title : 'About Us'});
});


router.get('/picupload',(req,res)=>{
    res.render('picupload' , {title : 'Upload a Pic'});
});


router.get('/adminhome',(req,res)=>{
    res.render('adminhomepage' , {title : 'Home Page'});
});


router.get('/adminusers',(req,res)=>{
    User.find()
        .then((result) =>{
          res.render('adminusers' , {title : 'Users' , theuser: result})
        })
        .catch((err)=>{
         console.log(err);
    })
    
});


router.get('/adminorders',(req,res)=>{
    Order.find()
    .then ((result) =>{
        res.render('adminorders' , {title : 'Orders' , theorders: result})
    })
    .catch((err)=>{
        console.log(err);
    })
    
});

router.get('/cart',(req,res)=>{
    res.render('cartpage' , {title : 'Cart'});
});


router.get('/ordercomplete',(req,res)=>{
    res.render('ordercomplete' , {title : 'Order Complete'});
});


router.post('/home',(req,res)=>{
 const user = new User(req.body);

 user.save()
    .then((result)=>{
        res.redirect('/home');
    })
    .catch((err)=>{
        console.log(err);
    })
});


router.post('/ordercomplete',(req,res)=>{
    const order = new Order(req.body);
   
    order.save()
       .then((result)=>{
           res.redirect('/ordercomplete');
       })
       .catch((err)=>{
           console.log(err);
       })
});


// router.post('/picupload',(req,res)=>{
    // const form = new formidable.IncomingForm()
    // const uploadFolder = '../public/files';
    // form.uploadDir = uploadFolder;
    // console.log(form);
    // form.parse(req, async (err, fields, files) => {
    //     if (err) {
    //       console.log("Error parsing the files");
    //     }

    //     const file = files.pic;
    //     try {
    //         const newpath = 'C:/Users/Layan/Desktop/'+file;
    //         // renames the file in the directory
    //         fs.rename(file.filepath, newpath , (err)=>{
    //             console.log(err);
    //         });
    //       } catch (error) {
    //         console.log(error);
    //       }
    //   });

    // res.render('picsubmit' , {title: 'pic'})


    // var form = new formidable.IncomingForm();

    // form.parse(req);

    // form.on('fileBegin', function (name, file){
    //     file.path = __dirname + '../public/files' + file.name;
    // });

    // form.on('file', function (name, file){
    //     console.log('Uploaded ' + file.name);
    // });

    // res.sendFile({ root: path.join(__dirname, '../public') });

// })

router.use((req,res)=>{
    res.status('404').render('404page' , {title : 'Error'});
});

   module.exports = router;