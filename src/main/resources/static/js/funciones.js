//consultar la tabla de category
function traerCategory(){
    $.ajax({
        url: 'http://localhost:80/api/Category/all',
        type: 'GET',
        datatype: 'json',

        success: function (category) {
            console.log(category)

            let myTable = '<table border="1">';
            myTable += "<tr>";
            myTable += '<th> NAME </th>';
            myTable += '<th> DESCRIPTION </th>';
            myTable += "</tr>";

            for (let i = 0; i < category.length; i++) {
                myTable += "<tr>";
                myTable += "<td>" + category[i].name + "</td>";
                myTable += "<td>" + category[i].description + "</td>";
                myTable += "</tr>";
            }
            myTable += "</table>";
            $('#listaCategory').empty();
            $('#listaCategory').append(myTable);

        }
    })
}

function guardarCategory(){

    let nombre=$('#nameCategory').val()
    let descripcion=$('#descriptionCategory').val()

    let data={
        name:nombre,
        description:descripcion
    };
    let dataToSend=JSON.stringify(data)
    $.ajax({
        url: 'http://localhost:80/api/Category/save',
        type: 'POST',
        datatype: 'json',
        data:dataToSend,
        contentType:'application/json',
        success:function (category){
            console.log(category)
            $('#nameCategory').val("");
            $('#descriptionCategory').val("");
            alert("GUARDADO CORRECTAMENTE")
        },
        complete:function (){
            traerCategory();
        }

    })
}
//consultar la tabla de salon

function traerSala(){
    $.ajax({
        url: 'http://localhost:80/api/Partyroom/all',
        type: 'GET',
        datatype: 'json',

        success: function (Partyroom) {
            console.log(Partyroom)

            let myTable = '<table border="1">';
            myTable += "<tr>";
            myTable += '<th> OWNER </th>';
            myTable += '<th> NAME </th>';
            myTable += '<th> CAPACITY </th>';
            myTable += '<th> DESCRIPTION </th>';
            myTable += "</tr>";

            for (let i = 0; i < Partyroom.length; i++) {
                myTable += "<tr>";
                myTable += "<td>" + Partyroom[i].owner+ "</td>";
                myTable += "<td>" + Partyroom[i].name+ "</td>";
                myTable += "<td>" + Partyroom[i].capacity+ "</td>";
                myTable += "<td>" + Partyroom[i].description + "</td>";
                myTable += "<tr>";

            }
            myTable += "</table>";
            $('#listaSalones').empty();
            $('#listaSalones').append(myTable);

        }
    })
}
function guardarSala(){

    let owner=$('#ownerSalon').val();
    let name=$('#nameSalon').val();
    let capacity=$('#capacitySalon').val();
    let description=$('#descriptionSalon').val();


    let data={
        owner:owner,
        name:name,
        capacity:capacity,
        description:description


    };
    let dataToSend = JSON.stringify(data);

    $.ajax({
        url:'http://localhost:80/api/Partyroom/save',
        type:'POST',
        datatype:'json',
        data:dataToSend,
        contentType : 'application/json',
        success :function(Partyroom){
            console.log(Partyroom)
            $('#ownerSalon').val("");
            $('#nameSalon').val("");
            $('#capacitySalon').val("");
            $('#descriptionSalon').val("");

            alert("GUARDADO CORRECTAMENTE ")

        },
        complete:function(){
            traerSala();
        }
    });
}
//mostrar la tabla clientes
function traerCliente(){
    $.ajax({
        url: 'http://localhost:80/api/Client/all',
        type: 'GET',
        datatype: 'json',

        success: function (Client) {
            console.log(Client)

            let myTable = '<table border="1">';
            myTable += "<tr>";
            myTable += '<th> NAME </th>';
            myTable += '<th> EMAIL </th>';
            myTable += '<th> AGE </th>';
            myTable += "</tr>";

            for (let i = 0; i < Client.length; i++) {
                myTable += "<tr>";
                myTable += "<td>" + Client[i].name+ "</td>";
                myTable += "<td>" + Client[i].email+ "</td>";
                myTable += "<td>" + Client[i].age+ "</td>";
                myTable += "</tr>";
            }
            myTable += "</table>";
            $('#listaClientes').empty();
            $('#listaClientes').append(myTable);

        }
    })
}
function guardarCliente(){

    let name=$('#nameCliente').val()
    let email=$('#emailCliente').val()
    let age=$('#ageCliente').val()

    let data={
        name:name,
        email:email,
        age:age
    };
    let dataToSend=JSON.stringify(data)
    $.ajax({
        url: 'http://localhost:80/api/Client/save',
        type: 'POST',
        datatype: 'json',
        data:dataToSend,
        contentType:'application/json',
        success:function (Client){
            console.log(Client)
            $('#nameCliente').val("");
            $('#emailCliente').val("");
            $('#ageCliente').val("");
            alert("GUARDADO CORRECTAMENTE")
        },
        complete:function (){
            traerCliente();
        }

    })
}
//mostrar la table mensajes

function traerMessas(){
    $.ajax({
        url: 'http://localhost:80/api/Message/all',
        type: 'GET',
        datatype: 'json',

        success: function (Message) {
            console.log(Message)

            let myTable = '<table border="1">';
            myTable += "<tr>";
            myTable += '<th> MESSAGE </th>';
            myTable += "</tr>";

            for (let i = 0; i < Message.length; i++) {
                myTable += "<tr>";
                myTable += "<td>" + Message[i].messageText+ "</td>";
                myTable += "</tr>";
            }
            myTable += "</table>";
            $('#listaMessage').empty();
            $('#listaMessage').append(myTable);

        }
    })
}
function guardarMessas(){

    let messageText=$('#messageText').val()


    let data={
        messageText:messageText
    };
    let dataToSend=JSON.stringify(data)
    $.ajax({
        url: 'http://localhost:80/api/Message/save',
        type: 'POST',
        datatype: 'json',
        data:dataToSend,
        contentType:'application/json',
        success:function (Message){
            console.log(Message)
            $('#messageText').val("");
            alert("GUARDADO CORRECTAMENTE")
        },
        complete:function (){
            traerMessas();
        }
    })
}
//mostrar la tabla de reservas
function traerReserva(){
    $.ajax({
        url: 'http://localhost:80/api/Reservation/all',
        type: 'GET',
        datatype: 'json',

        success: function (Reservation) {
            console.log(Reservation)

            let myTable = '<table border="1">';
            myTable += "<tr>";
            myTable += '<th> ID </th>';
            myTable += '<th> STARTDATE </th>';
            myTable += '<th> DEVOLUTIONDATE </th>';
            myTable += "</tr>";

            for (let i = 0; i < Reservation.length; i++) {
                myTable += "<tr>";
                myTable += "<td>" + Reservation[i].idReservation+ "</td>";
                myTable += "<td>" + Reservation[i].startDate+ "</td>";
                myTable += "<td>" + Reservation[i].devolutionDate+ "</td>";
                myTable += "</tr>";
            }
            myTable += "</table>";
            $('#listaReserva').empty();
            $('#listaReserva').append(myTable);

        }
    })
}
function guardarReserva(){

    let startDate=$('#startDate').val()
    let devolutionDate=$('#devolutionDate').val()


    let data={
        startDate:startDate,
        devolutionDate:devolutionDate
    };
    let dataToSend=JSON.stringify(data)
    $.ajax({
        url: 'http://localhost:80/api/Reservation/save',
        type: 'POST',
        datatype: 'json',
        data:dataToSend,
        contentType:'application/json',
        success:function (Reservation){
            console.log(Reservation)
            $('#startDate').val("")
            $('#devolutionDate').val("")
            alert("GUARDADO CORRECTAMENTE")
        },
        complete:function (){
            traerReserva();
        }
    })
}

//mostrar la tabla admin
function traerAdmin(){
    $.ajax({
        url: 'http://localhost:80/api/Admin/all',
        type: 'GET',
        datatype: 'json',

        success: function (Admin) {
            console.log(Admin)

            let myTable = '<table border="1">';
            myTable += "<tr>";
            myTable += '<th> NAME </th>';
            myTable += '<th> EMAIL </th>';
            myTable += "</tr>";

            for (let i = 0; i < Admin.length; i++) {
                myTable += "<tr>";
                myTable += "<td>" + Admin[i].name+ "</td>";
                myTable += "<td>" + Admin[i].email+ "</td>";
                myTable += "</tr>";
            }
            myTable += "</table>";
            $('#admin').empty();
            $('#admin').append(myTable);

        }
    })
}
function guardarAdmin(){

    let name=$('#nameAdmin').val()
    let email=$('#emailAdmin').val()
    let password=$('#passwordAdmin').val()

    let data={
        name:name,
        email:email,
        password:password
    };
    let dataToSend=JSON.stringify(data)
    $.ajax({
        url: 'http://localhost:80/api/Admin/save',
        type: 'POST',
        datatype: 'json',
        data:dataToSend,
        contentType:'application/json',
        success:function (Admin){
            console.log(Admin)
            $('#nameAdmin').val("");
            $('#emailAdmin').val("");
            $('#passwordAdmin').val("");
            alert("GUARDADO CORRECTAMENTE")
        },
        complete:function (){
            traerAdmin();
        }

    })
}