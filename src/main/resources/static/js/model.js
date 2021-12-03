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

            // console.log(response[0])
            // console.log("Back spaceeeeeeeeeeeeee")
            // console.log(response[1])
            const brands = response[0].at(modelName);
            const models = response[1];
            const selectBrand = brands.brand.brandName;
            console.log(selectBrand)
// [[Models(id=11, modelName=, entryDate=2021-12-03 14:15:28.72, brand=Brand(id=8, brandName=MicroMac, entryDate=2021-12-02 20:03:14.454))], [Brand(id=8, brandName=MicroMac, entryDate=2021-12-02 20:03:14.454), Brand(id=11, brandName=MicroMac, entryDate=2021-12-03 15:17:46.172), Brand(id=15, brandName=MicroMac, entryDate=2021-12-03 00:05:17.676), Brand(id=17, brandName=MicroMacf, entryDate=2021-12-03 00:43:22.546), Brand(id=18, brandName=MicroMacs121, entryDate=2021-12-03 12:45:47.687), Brand(id=39, brandName=MicroMac, entryDate=2021-12-03 14:14:29.235), Brand(id=40, brandName=Aarong, entryDate=2021-12-03 02:25:24.32), Brand(id=41, brandName=MicroMac, entryDate=2021-12-03 02:21:00.455), Brand(id=46, brandName=Orange, entryDate=2021-12-03 12:59:16.893), Brand(id=56, brandName=Aarong, entryDate=2021-12-03 15:18:32.372), Brand(id=57, brandName=, entryDate=2021-12-03 15:18:45.177), Brand(id=58, brandName=, entryDate=2021-12-03 15:18:51.053)]]
//             const brandData = response[0].brand;

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
            alert('Model has been updated successfully')

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
            alert('Model has been updated successfully')

        }
        ,
        error: function (e) {
            // alert('Error: ' + e);
        }
    });

}

