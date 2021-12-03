// function brandValidation() {
//
//     var brandN = document.getElementById('modelNameUpdate').value;
//     var brandUpdate = document.getElementById('modelName').value;
//     var check = document.getElementById('updateId');
//     console.log(brandN);
//     console.log(brandUpdate);
//
//     $.ajax({
//         type: "GET",
//         url: "http://localhost:8085/model/find-brand",
//         dataType: "json",
//         contentType: "application/json; charset=utf-8",
//
//         success: function (response) {
//
//             const brandValue =response[0].modelName;
//             console.log();
//             for (idx in response){
//                 if (response[idx].modelName == brandN || response[idx].modelName == brandUpdate ){
//                     alert('Already Exist!')
//                     $(":submit").attr("disabled", true);
//                 }else{
//                     $(":submit").attr("enable", true);
//                     if (response[idx].modelName == brandN || response[idx].modelName == brandUpdate ){
//                         alert('Already Exist!')
//                         $(":submit").removeAttr("disabled");
//                     }
//                 }
//             }
//
//         }
//         ,
//         error: function (e) {
//             // alert('Error getUpdateBrand: ' + e);
//         }
//     });
// }