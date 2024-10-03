const getAllCategory = () => {
    return $.ajax({
        header: {
            'Accept' : 'application/json',
            'Content-Type' : 'application/json'
        },
        type: 'GET',
        url: 'http://localhost:8080/api/categories'
    })
}