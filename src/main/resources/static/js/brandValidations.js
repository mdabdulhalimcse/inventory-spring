// function brandValidation() {
//
//     var brandN = document.getElementById('brandNameUpdate').value;
//     var brandUpdate = document.getElementById('brandName').value;
//     var check = document.getElementById('updateId');
//     console.log(brandN);
//     console.log(brandUpdate);
//
//     $.ajax({
//         type: "GET",
//         url: "http://localhost:8085/brand/find-brand",
//         dataType: "json",
//         contentType: "application/json; charset=utf-8",
//
//         success: function (response) {
//
//             const brandValue =response[0].brandName;
//             console.log();
//             for (idx in response){
//                 if (response[idx].brandName == brandN || response[idx].brandName == brandUpdate ){
//                     alert('Already Exist!')
//                     $(":submit").attr("disabled", true);
//                 }else{
//                     if (response[idx].brandName == brandN || response[idx].brandName == brandUpdate ){
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