( function ( $ ) {
    "use strict";

    //Team chart
    var ctx = document.getElementById( "team-chart" );
    var element = document.getElementById('price').innerHTML;
    var x=[];
    $('t1 tr').each(function(){
        var id=$(this).find('td').eq(1).html();
        console.log(id);
        x.push(id);
    });
    ctx.height = 150;
    var myChart = new Chart( ctx, {

        type: 'line',
        data: {
            labels: [ "1", "2", "3", "4", "5", "6", "7","8","9","10","11","12"],
            type: 'line',
            defaultFontFamily: 'Montserrat',
            datasets: [ {
                data: [500000,0,400000,0,300000,0,0,0,0,0,600000,0],
                label: "Expense",
                backgroundColor: 'rgba(0,103,255,.15)',
                borderColor: 'rgba(0,103,255,0.5)',
                borderWidth: 3.5,
                pointStyle: 'circle',
                pointRadius: 5,
                pointBorderColor: 'transparent',
                pointBackgroundColor: 'rgba(0,103,255,0.5)',
                    }, ]
        },
        options: {
            responsive: true,
            tooltips: {
                mode: 'index',
                titleFontSize: 12,
                titleFontColor: '#000',
                bodyFontColor: '#000',
                backgroundColor: '#fff',
                titleFontFamily: 'Montserrat',
                bodyFontFamily: 'Montserrat',
                cornerRadius: 3,
                intersect: false,
            },
            legend: {
                display: false,
                position: 'top',
                labels: {
                    usePointStyle: true,
                    fontFamily: 'Montserrat',
                },


            },
            scales: {
                xAxes: [ {
                    display: true,
                    gridLines: {
                        display: false,
                        drawBorder: false
                    },
                    scaleLabel: {
                        display: false,
                        labelString: 'Month'
                    }
                        } ],
                yAxes: [ {
                    display: true,
                    gridLines: {
                        display: false,
                        drawBorder: false
                    },
                    scaleLabel: {
                        display: true,
                        labelString: 'Value'
                    }
                        } ]
            },
            title: {
                display: false,
            }
        }
    } );


} )( jQuery );
// function data() {
//     var connection = new ActiveXObject("ADODB.Connection");
//
//     var connectionstring = "jdbc:mysql://localhost:3309/COP_v1;username=Nhom22_v1;password=123";
//     connection.Open(connectionstring);
//     var rs = new ActiveXObject("ADODB.Recordset");
//
//     rs.Open("SELECT * FROM car", connection);
//     rs.MoveFirst
//     while (!rs.eof) {
//         getSelectedRow = function(val)
//         {
//             db.transaction(function(transaction) {
//                 transaction.Open('SELECT * FROM car;', selectedRowValues, errorHandler);
//
//             });
//         };
//         selectedRowValues = function(transaction,results)
//         {
//             for(var i = 0; i < results.rows.length; i++)
//             {
//                 var row = results.rows.item(i);
//                 alert(row['number']);
//                 alert(row['name']);
//             }
//         };
//         rs.movenext;
//     }
//
//     rs.close;
//     connection.close;
//
// }


