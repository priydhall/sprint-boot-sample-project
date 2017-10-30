$(document).ready(function(){

    $('#news-create-form').validate({
        rules: {
            newsTitle: {
                required: true
            },
            newsBody: {
                required: true
            },
            newsAuthor: {
                required: true
            },
            newsPublishDate: {
                required: true
            }
        },
        highlight: function(element) {
            $(element).closest('.form-group').addClass('has-error');
        },
        unhighlight: function(element) {
            $(element).closest('.form-group').removeClass('has-error');
        },
        errorElement: 'span',
        errorClass: 'help-block',
        errorPlacement: function(error, element) {
            if(element.parent('.input-group').length) {
                error.insertAfter(element.parent());
            } else {
                error.insertAfter(element);
            }
        },
        submitHandler: function(event) {
            // event.preventDefault();
            var values = {};
            $.each($('#news-create-form').serializeArray(), function(i, field) {
                values[field.name] = field.value;
            });


            var url = '/api/v2/news/';

            $.ajax({
                type: "POST",
                url: url,
                dataType: "json",
                data: JSON.stringify(values),
                success: function(responseObject){
                    if(responseObject.statusCode === "201"){
                        toastr.success(responseObject.message)
                    }
                    else {
                        toastr.error(responseObject.message)
                        // toastr.error(responseObject.exceptionMessage)
                    }
                },
                contentType: "application/json"
            });
        }
    })
})