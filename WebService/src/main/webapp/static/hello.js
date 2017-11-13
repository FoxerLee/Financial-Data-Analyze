function requestData() {
    $.ajax({
        url:"requestData",
        type:"get",
        success:function (response) {
            $(".id").append(response.id);
        },
        error:function (xhr, ajaxOptions, thrownError) {
            alert("error!");
        }
    });
}