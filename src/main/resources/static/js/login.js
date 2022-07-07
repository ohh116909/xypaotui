$(function () {
    
    $('.forgotBtn').click(function () {
        $('#forgot').toggleClass('toggle')
    })

    $('.registerBtn').click(function () {
        $('#register, #formContainer').toggleClass('toggle')
    })
    $('#qqbtn').click(function(){
        $('#qqLogin').toggleClass('toggle')
        
    })
    $('#wxbtn').click(function(){
        $('#wxLogin').toggleClass('toggle')
    })
    $('#dxbtn').click(function(){
        $('#dxLogin').toggleClass('toggle')
    })

    $('#btn01').click(function(){
        $('#qqLogin').toggleClass('toggle')
    })
    $('#btn02').click(function(){
        $('#wxLogin').toggleClass('toggle')
    })
    $('#btn03').click(function(){
        $('#dxLogin').toggleClass('toggle')
    })
})