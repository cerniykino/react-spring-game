function button(direction) {
    $.ajax({
        url: "/TiltMaze/refresh-field?direction=" + direction,
        type: "GET",
        success: function(data) {
            // Reload the page to show the refreshed field
            location.reload();
        },
        error: function(xhr, status, error) {
            // Handle any errors here
            console.error(error);
        }
    });
}

function updateScores() {
    // $.ajax({
    //     url: "/TiltMaze/scores",
    //     type: "GET",
    //     success: function(data) {
    //         // Update the table with the new scores
    //         $("#score-table tbody").html(data);
    //     }
    // });
        $.ajax({
        url: "TiltMaze/scores",
        type: "GET",
        dataType: "json",

        success: function(data) {
        var table = "<table><thead><tr><th>Rank</th><th>Player</th><th>Score</th></tr></thead><tbody>";
        for (var i = 0; i < data.length; i++) {
        table += "<tr><td>" + (i + 1) + "</td><td>" + data[i].player + "</td><td>" + data[i].points + "</td></tr>";
    }
        table += "</tbody></table>";
        $("#score-table").html(table);
    }
    });
}
const btn = document.querySelector("button")
$("#commentForm").submit(function (event) {
    event.preventDefault();
    alert("dsadsad");
    const username = $("#username").val();
    const comment = $("#comment").val();
    
    $.ajax({
        url: "/TiltMaze/add-comment?username="+username + "&comment=" + comment,
        type: "POST",
        data: { player: username, comment: comment },
        success: function (data) {
            alert("Comment added ");

        },
        error: function (error) {
            console.error("Error adding comment:", error);
        },
    });
});

// function sub() {
//     const username = $("#username").val();
//     const comment = $("#comment").val();
//
//     $.ajax({
//         url: "/TiltMaze/add-comment?username="+username + "&comment=" + comment,
//         type: "POST",
//         data: { player: username, comment: comment },
//         success: function (data) {
//             alert("Comment added successfully");
//
//         },
//         error: function (error) {
//             console.error("Error adding comment:", error);
//         },
//     });
// }
