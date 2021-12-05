var brandI;

function saveBrand() {

    var nameValue = document.getElementById("brandName").value;

    if (nameValue == null || nameValue == undefined || nameValue == ''){
        console.log('required brand name')
    }
    var data = {
        brandName: nameValue
    }

    $.ajax({
        type: "POST",
        url: "http://localhost:8085/brand/add",
        dataType: "json",
        data: JSON.stringify(data),
        contentType: "application/json; charset=utf-8",

        success: function (response) {
            if (response == 'success'){
                alert('Brand has been added successfully')
            }
            else if (response == 'dublicate'){
                alert('Sorry!!!. Your brand name already exists!')
            }else{
                alert('Internal Error!')
            }
        }
        ,
        error: function (e) {
            // alert('Error saveBrand: ' + e);
        }
    });
}

function getUpdateBrand(id) {
    brandI = id;

var brandN = document.getElementById('brandNameUpdate');

    $.ajax({
        type: "GET",
        url: "http://localhost:8085/brand/update-data/"+brandI,
        dataType: "json",
        contentType: "application/json; charset=utf-8",

        success: function (response) {
            // console.log('response is: ' + response[0].brandName);
            brandN.value=response[0].brandName;
            $('#myModalUpdate').modal('toggle');
        }
        ,
        error: function (e) {
            // alert('Error getUpdateBrand: ' + e);
        }
    });
}

function deleteBrand(id) {
    var delId = document.getElementById('deleteId');
    // confirm("");
    const brandId = id;
    if (confirm('Are You sure to delete the selected brand?')) {

        $.ajax({
            type: "GET",
            url: "http://localhost:8085/brand/delete/"+brandId,
            dataType: "json",
            contentType: "application/json; charset=utf-8",

            success: function (response) {

            }
            ,
            error: function (e) {
                // alert('Error getUpdateBrand: ' + e);
            }
        });
    } else {

    }
}

function updateBrand() {

    var nameValue = document.getElementById("brandNameUpdate").value;
    let brand = brandI;
    if (nameValue == null || nameValue == undefined || nameValue == ''){
        console.log('required brand name')
    }
    var data = {
        id:brand,
        brandName: nameValue
    }

    $.ajax({
        type: "POST",
        url: "http://localhost:8085/brand/update",
        dataType: "json",
        data: JSON.stringify(data),
        contentType: "application/json; charset=utf-8",

        success: function (response) {
            if (response == 'success'){
                alert('Brand has been added successfully')
            }
            else if (response == 'dublicate'){
                alert('Sorry!!!. Your brand name already exists!')
            }else{
                alert('Internal Error!')
            }
        }
        ,
        error: function (e) {
            // alert('Error updateBrand: ' + e);
        }
    });
}

