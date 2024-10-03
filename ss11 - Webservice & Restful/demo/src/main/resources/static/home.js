async function listBlogs(page = 0) {
    const listBlogs = await getAllBlogs(page);
    $('#list-blogs').append(renderBlogs(listBlogs));
    renderPagination(listBlogs);
}

async function searchBlogs(page = 0) {
    const listBlogs = await searchByTitle(page);
    $('#list-blogs').html(renderBlogs(listBlogs));
    renderPagination(listBlogs);
}

function renderBlogs(listBlogs) {
    if (!listBlogs) {
        $('#list-blogs').html('<h3 class="text-center">Danh sách rỗng!</h3>');
        renderPagination(0);
        return;
    }
    let blog = '';
    listBlogs.content.forEach(el => {
        blog += `
        <div class="row">
            <div class="col-11">
                <h6><span>Tác giả: </span><span>${el.author}</span></h6>
                <a class="text-decoration-none text-dark" href="/blogs/detail/${el.id}">
                    <h4>${el.title}</h4>
                </a>
                <div ${el.category != null}">
                    <span class="badge bg-primary">${el.category.name}</span>
                </div>
            </div>
            <div class="col-1 align-content-end">
                <div class="dropdown">
                    <div style="cursor: pointer" data-bs-toggle="dropdown" aria-expanded="false">
                        <i class="bi bi-list-ul fs-3"></i>
                    </div>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="/blogs/update/${el.id}">Chỉnh sửa</a></li>
                        <li><a class="dropdown-item" href="/blogs/delete/${el.id}">Xóa</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <hr>`;
    });
    return blog;
}

function renderPagination(pageData) {
    const paginationControls = $('#pagination-controls');
    let pagination = '';
    if (pageData.totalPages > 1) {
        if (pageData.number < pageData.totalPages - 1) {
            pagination += `<button class="btn btn-primary ms-2" onclick="listBlogs(${pageData.number + 1})">Xem thêm</button>`;
        } else {
            pagination = "";
        }
    }
    paginationControls.html(pagination);
}

$(document).ready(() => {
    header().then(() => {
        $('#search').click(() => searchBlogs(0));
    });
    listBlogs();
});