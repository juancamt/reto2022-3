//consultar la tabla de category
function traerCategory(){
    $.ajax({
        url: 'http://129.80.156.8:8989/api/Category/all',
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
//Para guardar category
function guardarCategory(){

    let nombre=$('#nameCategory').val()
    let descripcion=$('#descriptionCategory').val()

    let data={
        name:nombre,
        description:descripcion
    };
    let dataToSend=JSON.stringify(data)
    $.ajax({
        url: 'http://129.80.156.8:8989/api/Category/save',
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
//para la actualisacion de category
function traerCategoryGet(){
    $.ajax({
        url: 'http://129.80.156.8:8989/api/Category/all',
        type: 'GET',
        datatype: 'json',

        success: function (category) {
            console.log(category)

            let myTable = '<table border="1">';
            myTable += "<tr>";
            myTable += '<th> ID </th>';
            myTable += '<th> NAME </th>';
            myTable += '<th> DESCRIPTION </th>';
            myTable += "</tr>";

            for (let i = 0; i < category.length; i++) {
                myTable += "<tr>";
                myTable += "<td>" + category[i].id + "</td>";
                myTable += "<td>" + category[i].name + "</td>";
                myTable += "<td>" + category[i].description + "</td>";
                myTable += "<td>  <button onClick='eliminarCategory( "+ category[i].id +")'>Borrar</button>";
                myTable += "</tr>";
            }
            myTable += "</table>";
            $('#listaCategory').empty();
            $('#listaCategory').append(myTable);

        }
    })
}
function actuaCategory(){

    let id =$('#idCategory').val()
    let name=$('#nameCategory').val()
    let description=$('#descriptionCategory').val()

    let data={
        id:id,
        name:name,
        description:description
    };
    let dataToSend=JSON.stringify(data)
    $.ajax({
        url: 'http://129.80.156.8:8989/api/Category/update',
        type: 'PUT',
        datatype: 'json',
        data:dataToSend,
        contentType:'application/json',
        success:function (category){
            console.log(category)
            $('#idCategory').val("")
            $('#nameCategory').val("");
            $('#descriptionCategory').val("");
            alert("ACTUALIZADO CORRECTAMENTE")
        },
        complete:function (){
            traerCategoryGet();

        }

    })
}
//Para la eliminacion de category
function eliminarCategory(id){
    $.ajax({
        url:'http://129.80.156.8:8989/api/Category/'+id,
        type:'DELETE',
        datatype:'json',
        contentType : 'application/json',
        success :function(category){
            console.log(category)
            $('#listaCategory').empty();
            alert("ELIMINADO CORRECTAMENTE")

        },
        complete:function(){
            traerCategoryGet();
        }

    });
}


//consultar la tabla de salon
function traerSala(){
    $.ajax({
        url: 'http://129.80.156.8:8989/api/Partyroom/all',
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
//guardar la tabla de salon
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
        url:'http://129.80.156.8:8989/api/Partyroom/save',
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
//para la actualizacion de salon
function traerPartyroomGet(){
    $.ajax({
        url: 'http://129.80.156.8:8989/api/Partyroom/all',
        type: 'GET',
        datatype: 'json',

        success: function (Partyroom) {
            console.log(Partyroom)

            let myTable = '<table border="1">';
            myTable += "<tr>";
            myTable += '<th> ID </th>';
            myTable += '<th> OWNER </th>';
            myTable += '<th> NAME </th>';
            myTable += '<th> CAPACITY </th>';
            myTable += '<th> DESCRIPTION </th>';
            myTable += "</tr>";

            for (let i = 0; i < Partyroom.length; i++) {
                myTable += "<tr>";
                myTable += "<td>" + Partyroom[i].id+ "</td>";
                myTable += "<td>" + Partyroom[i].owner+ "</td>";
                myTable += "<td>" + Partyroom[i].name+ "</td>";
                myTable += "<td>" + Partyroom[i].capacity+ "</td>";
                myTable += "<td>" + Partyroom[i].description + "</td>";
                myTable += "<td>  <button onClick='eliminarPartyroom( "+ Partyroom[i].id +")'>Borrar</button>";
                myTable += "<tr>";

            }
            myTable += "</table>";
            $('#listaSalones').empty();
            $('#listaSalones').append(myTable);

        }
    })
}
function actuaPartyroom(){
    let id=$("#idPartyroom").val();
    let owner=$('#ownerSalon').val();
    let name=$('#nameSalon').val();
    let capacity=$('#capacitySalon').val();
    let description=$('#descriptionSalon').val();


    let data={
        id:id,
        owner:owner,
        name:name,
        capacity:capacity,
        description:description
    };
    let dataToSend = JSON.stringify(data);
    $.ajax({
        url:'http://129.80.156.8:8989/api/Partyroom/update',
        type:'PUT',
        datatype:'json',
        data:dataToSend,
        contentType : 'application/json',
        success :function(Partyroom){
            console.log(Partyroom)
            $("#idPartyroom").val("");
            $('#ownerSalon').val("");
            $('#nameSalon').val("");
            $('#capacitySalon').val("");
            $('#descriptionSalon').val("");

            alert("ACTUALIZADO CORRECTAMENTE ")

        },
        complete:function(){
            traerPartyroomGet();
        }
    });
}
//para la eliminacion de partyroom
function eliminarPartyroom(id){

    $.ajax({
        url:'http://129.80.156.8:8989/api/Partyroom/'+id,
        type:'DELETE',
        datatype:'json',
        contentType : 'application/json',
        success :function(Partyroom){
            console.log(Partyroom)
            $('#listaSalones').empty();
            alert("ELIMINADO CORRECTAMENTE")

        },
        complete:function(){
            traerPartyroomGet();
        }

    });
}


//mostrar la tabla clientes
function traerCliente(){
    $.ajax({
        url: 'http://129.80.156.8:8989/api/Client/all',
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
//guardar la tabla de cliente
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
        url: 'http://129.80.156.8:8989/api/Client/save',
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
//para la actualizacion de cliente
function traerClienteGet(){
    $.ajax({
        url: 'http://129.80.156.8:8989/api/Client/all',
        type: 'GET',
        datatype: 'json',

        success: function (Client) {
            console.log(Client)

            let myTable = '<table border="1">';
            myTable += "<tr>";
            myTable += '<th> ID</th>';
            myTable += '<th> NAME </th>';
            myTable += '<th> EMAIL </th>';
            myTable += '<th> AGE </th>';
            myTable += "</tr>";

            for (let i = 0; i < Client.length; i++) {
                myTable += "<tr>";
                myTable += "<td>" + Client[i].idClient+ "</td>";
                myTable += "<td>" + Client[i].name+ "</td>";
                myTable += "<td>" + Client[i].email+ "</td>";
                myTable += "<td>" + Client[i].age+ "</td>";
                myTable += "<td>  <button onClick='eliminarCliente( "+ Client[i].idClient +")'>Borrar</button>";
                myTable += "</tr>";
            }
            myTable += "</table>";
            $('#listaClientes').empty();
            $('#listaClientes').append(myTable);

        }
    })
}
function actuaCliente(){
    let id=$('#idClient').val()
    let name=$('#nameCliente').val()
    let age=$('#ageCliente').val()

    let data={
        idClient:id,
        name:name,
        age:age
    };
    let dataToSend=JSON.stringify(data)
    $.ajax({
        url: 'http://129.80.156.8:8989/api/Client/update',
        type: 'PUT',
        datatype: 'json',
        data:dataToSend,
        contentType:'application/json',
        success:function (Client){
            console.log(Client)
            $('#idClient').val("");
            $('#nameCliente').val("");
            $('#ageCliente').val("");
            alert("ACTUALIZADO CORRECTAMENTE")
        },
        complete:function (){
            traerClienteGet();
        }
    })
}
//para la eliminacion de cliente
function eliminarCliente(idClient){
    $.ajax({
        url:'http://129.80.156.8:8989/api/Client/'+idClient,
        type:'DELETE',
        datatype:'json',
        contentType : 'application/json',
        success :function(Client){
            console.log(Client)
            $('#listaClientes').empty();
            alert("ELIMINADO CORRECTAMENTE")
        },
        complete:function(){
            traerClienteGet();
        }
    });
}

//mostrar la table message
function traerMessas(){
    $.ajax({
        url: 'http://129.80.156.8:8989/api/Message/all',
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
//guardar la tabla de message
function guardarMessas(){

    let messageText=$('#messageText').val()


    let data={
        messageText:messageText
    };
    let dataToSend=JSON.stringify(data)
    $.ajax({
        url: 'http://129.80.156.8:8989/api/Message/save',
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
//para la actualizacion de message
function traerMessasGet(){
    $.ajax({
        url: 'http://129.80.156.8:8989/api/Message/all',
        type: 'GET',
        datatype: 'json',

        success: function (Message) {
            console.log(Message)

            let myTable = '<table border="1">';
            myTable += "<tr>";
            myTable += '<th> ID </th>';
            myTable += '<th> MESSAGE </th>';
            myTable += "</tr>";

            for (let i = 0; i < Message.length; i++) {
                myTable += "<tr>";
                myTable += "<td>" + Message[i].idMessage+ "</td>";
                myTable += "<td>" + Message[i].messageText+ "</td>";
                myTable += "<td>  <button onClick='eliminarMessage( "+ Message[i].idMessage +")'>Borrar</button>";
                myTable += "</tr>";
            }
            myTable += "</table>";
            $('#listaMessage').empty();
            $('#listaMessage').append(myTable);

        }
    })
}
function ActuaMessas(){
    let id=$('#idMessage').val()
    let messageText=$('#messageText').val()
    let data={
        idMessage:id,
        messageText:messageText
    };
    let dataToSend=JSON.stringify(data)
    $.ajax({
        url: 'http://129.80.156.8:8989/api/Message/update',
        type: 'PUT',
        datatype: 'json',
        data:dataToSend,
        contentType:'application/json',
        success:function (Message){
            console.log(Message)
            $('#idMessage').val("")
            $('#messageText').val("");
            alert("ACTUALIZADO CORRECTAMENTE")
        },
        complete:function (){
            traerMessasGet();
        }
    })
}
//para la eliminacion de message
function eliminarMessage(idMessage){
    $.ajax({
        url: 'http://129.80.156.8:8989/api/Message/'+idMessage,
        type: 'DELETE',
        datatype: 'json',
        contentType:'application/json',
        success:function (Message){
            console.log(Message)
            $('#listaMessage').empty();
            alert("ELIMINADO CORRECTAMENTE")
        },
        complete:function (){
            traerMessasGet();
        }
    })
}

//mostrar la tabla de reservas
function traerReserva(){
    $.ajax({
        url: 'http://129.80.156.8:8989/api/Reservation/all',
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
//guardar la tabla de reserva
function guardarReserva(){

    let startDate=$('#startDate').val()
    let devolutionDate=$('#devolutionDate').val()


    let data={
        startDate:startDate,
        devolutionDate:devolutionDate
    };
    let dataToSend=JSON.stringify(data)
    $.ajax({
        url: 'http://129.80.156.8:8989/api/Reservation/save',
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
//para la actualizacion de reserva
function traerReservaGet(){
    $.ajax({
        url: 'http://129.80.156.8:8989/api/Reservation/all',
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
                myTable += "<td>  <button onClick='eliminarReservation( "+ Reservation[i].idReservation +")'>Borrar</button>";
                myTable += "</tr>";
            }
            myTable += "</table>";
            $('#listaReserva').empty();
            $('#listaReserva').append(myTable);

        }
    })
}
function actuaReservation(){
    let id=$('#idReservation').val()
    let startDate=$('#startDate').val()
    let devolutionDate=$('#devolutionDate').val()

    let data={
        idReservation:id,
        startDate:startDate,
        devolutionDate:devolutionDate
    };
    let dataToSend=JSON.stringify(data)
    $.ajax({
        url: 'http://129.80.156.8:8989/api/Reservation/update',
        type: 'PUT',
        datatype: 'json',
        data:dataToSend,
        contentType:'application/json',
        success:function (Reservation){
            console.log(Reservation)
            $('#idReservation').val("")
            $('#startDate').val("")
            $('#devolutionDate').val("")
            alert("ACTUALIZADO CORRECTAMENTE")
        },
        complete:function (){
            traerReservaGet();
        }
    })
}
//para la eliminacion de reservation
function eliminarReservation(idReservation){

    $.ajax({
        url:'http://129.80.156.8:8989/api/Reservation/'+idReservation,
        type:'DELETE',
        datatype:'json',
        contentType : 'application/json',
        success :function(Reservation){
            console.log(Reservation)
            $('#listaReserva').empty();
            alert("ELIMINADO CORRECTAMENTE")
        },
        complete:function(){
            traerReservaGet();
        }

    });
}

//mostrar la tabla admin
function traerAdmin(){
    $.ajax({
        url: 'http://129.80.156.8:8989/api/Admin/all',
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
        url: 'http://129.80.156.8:8989/api/Admin/save',
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
//para la actualizacion de admin
function traerAdminGet(){
    $.ajax({
        url: 'http://129.80.156.8:8989/api/Admin/all',
        type: 'GET',
        datatype: 'json',

        success: function (Admin) {
            console.log(Admin)

            let myTable = '<table border="1">';
            myTable += "<tr>";
            myTable += '<th> ID </th>';
            myTable += '<th> NAME </th>';
            myTable += '<th> EMAIL </th>';
            myTable += "</tr>";

            for (let i = 0; i < Admin.length; i++) {
                myTable += "<tr>";
                myTable += "<td>" + Admin[i].idAdmin+ "</td>";
                myTable += "<td>" + Admin[i].name+ "</td>";
                myTable += "<td>" + Admin[i].email+ "</td>";
                myTable += "<td>  <button onClick='eliminarAdmin( "+ Admin[i].idAdmin +")'>Borrar</button>";
                myTable += "</tr>";
            }
            myTable += "</table>";
            $('#admin').empty();
            $('#admin').append(myTable);

        }
    })
}
function actuaAdmin(){
    let id=$('#idAdmin').val()
    let name=$('#nameAdmin').val()
    let password=$('#passwordAdmin').val()

    let data={
        idAdmin:id,
        name:name,
        password:password
    };
    let dataToSend=JSON.stringify(data)
    $.ajax({
        url: 'http://129.80.156.8:8989/api/Admin/update',
        type: 'PUT',
        datatype: 'json',
        data:dataToSend,
        contentType:'application/json',
        success:function (Admin){
            console.log(Admin)
            $('#idAdmin').val("");
            $('#nameAdmin').val("");
            $('#passwordAdmin').val("");
            alert("SE ACTUALIZO NOMBRE Y CONTRASEÑA")
        },
        complete:function (){
            traerAdminGet();
        }

    })
}

//para la eliminacion de admin
function eliminarAdmin(idAdmin){

    $.ajax({
        url:'http://129.80.156.8:8989/api/Admin/'+idAdmin,
        type:'DELETE',
        datatype:'json',
        contentType : 'application/json',
        success :function(Admin){
            console.log(Admin)
            $('#listaReserva').empty();
            alert("ELIMINADO CORRECTAMENTE")
        },
        complete:function(){
            traerAdminGet();
        }

    });
}