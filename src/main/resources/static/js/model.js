var brandI;

function getBrandList(){

 var selectBrand = document.getElementById('brandName');
    $("#brandName option:selected").val('Select Brand');
    $.ajax({
        type: "GET",
        url: "http://localhost:8085/model/getBrand",
        dataType: "json",
        contentType: "application/json; charset=utf-8",
        success: function (response) {
            const newOption = document.createElement('option');
            const optionText = document.createTextNode('----Slect Brand ----');
            newOption.appendChild(optionText);
            selectBrand.appendChild(newOption);
            newOption.setAttribute('value','0');
            for(idx in response){
                console.log(response[idx].brandName);
                const newOption = document.createElement('option');
                const optionText = document.createTextNode(response[idx].brandName);
                newOption.appendChild(optionText);
                selectBrand.appendChild(newOption);
                newOption.setAttribute('value',response[idx].id);

            }
            $('#myModal').modal('toggle');


        }
        ,
        error: function (e) {
            // alert('Error: ' + e);
        }
    });

}


function getUpdateModels(id) {
    brandI = id;

    var modelN = document.getElementById('modelNameUpdate');
    var brandN = document.getElementById('brandNameUpdate');
    var selectBrand = document.getElementById('brandName');
    $.ajax({
        type: "GET",
        url: "http://localhost:8085/model/update-data/"+brandI,
        dataType: "json",
        // data: JSON.stringify(data),
        contentType: "application/json; charset=utf-8",

        success: function (response) {

            const brands = response[0].at(modelName);
            const models = response[1];
            const selectBrand = brands.brand.brandName;
            console.log(selectBrand)

             modelN.value=brands.modelName;
             brandN.value=selectBrand;
            const newOption = document.createElement('option');
            const optionText = document.createTextNode(selectBrand);
            newOption.appendChild(optionText);
            brandN.appendChild(newOption);
            newOption.setAttribute('value',brandI);

            for(idx in models){

                const newOption = document.createElement('option');
                const optionText = document.createTextNode(models[idx].brandName);
                newOption.appendChild(optionText);
                brandN.appendChild(newOption);
                newOption.setAttribute('value',models[idx].id);

            }

            $('#myModalUpdate1').modal('toggle');

        }
        ,
        error: function (e) {
            // alert('Error getUpdateBrand: ' + e);
        }
    });
}



function addModel(){

 var brandName = document.getElementById('brandName').value;
 var modelName = document.getElementById('modelName').value;

    var data = {
        brandName: brandName,
        modelName: modelName
    }

    $.ajax({
        type: "Post",
        url: "http://localhost:8085/model/add",
        dataType: "json",
        data: JSON.stringify(data),
        contentType: "application/json; charset=utf-8",
        //data: "year=" +  year + "&month=" +  month+ "&from=" +  from + "&to=" +  to,
        success: function (response) {
            if (response == 'success'){
                alert('Brand has been added successfully')
            }
            else if (response == 'duplicate'){
                alert('Sorry!!!. Your brand name already exists!')
            }else{
                alert('Internal Error!')
            }

        }
        ,
        error: function (e) {
            // alert('Error: ' + e);
        }
    });

}

function addModelUpdate(){
var getId = brandI;
 var brandName = document.getElementById('brandNameUpdate').value;
 var modelName = document.getElementById('modelNameUpdate').value;

    // alert('Model has been added successfully')

    //alert('Hi')
    var data = {
        id: getId,
        brandName: brandName,
        modelName: modelName
    }

    $.ajax({
        type: "Post",
        url: "http://localhost:8085/model/update",
        dataType: "json",
        data: JSON.stringify(data),
        contentType: "application/json; charset=utf-8",
        //data: "year=" +  year + "&month=" +  month+ "&from=" +  from + "&to=" +  to,
        success: function (response) {
            if (response == 'success'){
                alert('Brand has been added successfully')
            }
            else if (response == 'duplicate'){
                alert('Sorry!!!. Your brand name already exists!')
            }else{
                alert('Internal Error!')
            }
        }
        ,
        error: function (e) {
            // alert('Error: ' + e);
        }
    });

}

function deleteModels(id) {
    var delId = document.getElementById('deleteId');
    const modelId = id;
    if (confirm('Are You sure to delete the selected brand?')) {

        $.ajax({
            type: "GET",
            url: "http://localhost:8085/model/delete/"+modelId,
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

