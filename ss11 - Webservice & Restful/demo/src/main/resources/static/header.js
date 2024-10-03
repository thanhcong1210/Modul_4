async function header() {
    const listCate = await getAllCategory();

    let category = "";
    listCate.forEach(el => {
        category += `<li><a class="dropdown-item" href="/blogs/category/{id}(id=${el.id})">${el.name}</a></li>`;
    });
    return (`
    <nav class="navbar navbar-expand-lg bg-warning py-3 shadow">
        <div class="container">
            <a class="navbar-brand" href="#">Bloger</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/api/blogs">Danh sách blog</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/blogs/create">Đăng blog</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                            aria-expanded="false">
                            Danh mục
                        </a>
                        <ul class="dropdown-menu">
                            <a href="/blogs/list" class="dropdown-item">Tất cả</a>
                            ${category}
                        </ul>
                    </li>
                </ul>
                <div class="d-flex">
                    <input class="form-control me-2 bg-warning-subtle" type="search" id="keyword" placeholder="Tìm kiếm..."
                        aria-label="Search">
                    <button class="btn btn-secondary w-50" id="search" type="submit">Tìm kiếm</button>
                </div>
            </div>
        </div>
    </nav>
    `)
}
header().then(data => {
    $('body').prepend(data);
    $('#search').click(searchBlogs)
})