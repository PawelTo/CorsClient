$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8080/cors-server"
    }).then(function(data) {
       $('.received-id').append(data.id);
       $('.received-name').append(data.name);
    });
});