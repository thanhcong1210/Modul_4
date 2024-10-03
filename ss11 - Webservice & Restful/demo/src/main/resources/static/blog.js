const getAllBlogs = (page) => {
    return $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: 'GET',
        url: `http://localhost:8080/api/blogs?page=${page}`
    });
}


const searchByTitle = () => {
    let keyword = $('#keyword').val();

    return $.ajax({
        header: {
            'Accept' : 'application/json',
            'Content-Type' : 'application/json'
        },
        type: 'GET',
        url: `http://localhost:8080/api/blogs/search?keyword=${keyword}`
    })
}