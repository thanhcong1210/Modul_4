$(document).ready(function() {
    // Tìm kiếm blog
    $("#searchForm").submit(function (event) {
        event.preventDefault();
        var searchQuery = $("#searchQuery").val();
        $.ajax({
            url: "/blog/search",
            type: "GET",
            data: {
                nameBlog: searchQuery
            },
            success: function (data) {
                var blogTableBody = $("#blogTable tbody");
                blogTableBody.empty();
                $.each(data, function (index, blog) {
                    var row = $("<tr></tr>");
                    row.append($("<td></td>").text(index + 1));
                    row.append($("<td></td>").text(blog.id));
                    row.append($("<td></td>").text(blog.name));
                    row.append($("<td></td>").text(blog.title));
                    row.append($("<td></td>").text(blog.author));
                    row.append($("<td></td>").text(blog.content));
                    row.append($("<td></td>").text(blog.category.name));
                    row.append(
                        `<td>
                            <div class="d-flex justify-content-between">
                                <button class="btn btn-warning" onclick="window.location.href='/blog/update/${blog.id}'">Sửa</button>
                                <button class="btn btn-danger deleteBlogButton" data-id="${blog.id}">Xóa</button>
                                <button class="btn btn-info" onclick="window.location.href='/blog/detail/${blog.id}'">Chi tiết</button>
                            </div>
                        </td>`
                    );
                    blogTableBody.append(row);
                });
            },
            error: function (error) {
                console.error("Đã xảy ra lỗi với yêu cầu tìm kiếm:", error);
            }
        });
    });

    // Tải thêm bài viết
    let currentPage = parseInt($('#currentPage').val()) || 0;
    let pageSize = 10;
    let isLoading = false;

    function loadBlogs(page) {
        if (isLoading) return;
        isLoading = true;

        $.ajax({
            url: '/blog/loadMore?page=' + page,
            method: 'GET',
            success: function(response) {
                if (response.length > 0) {
                    let existingIds = new Set();
                    $('#blogTable tbody tr').each(function() {
                        existingIds.add($(this).data('id'));
                    });

                    response.forEach(function(blog) {
                        if (!existingIds.has(blog.id)) {
                            $('#blogTable tbody').append('<tr data-id="' + blog.id + '">' +
                                '<td>' + (page * pageSize + $('#blogTable tbody tr').length + 1) + '</td>' +
                                '<td>' + blog.id + '</td>' +
                                '<td>' + blog.name + '</td>' +
                                '<td>' + blog.title + '</td>' +
                                '<td>' + blog.author + '</td>' +
                                '<td>' + blog.content + '</td>' +
                                '<td>' + blog.category.name + '</td>' +
                                '<td>' +
                                '<div class="d-flex justify-content-between">' +
                                '<button class="btn btn-warning" onclick="window.location.href=\'/blog/update/' + blog.id + '\'">Sửa</button>' +
                                '<button class="btn btn-danger deleteBlogButton" data-id="' + blog.id + '">Xóa</button>' +
                                '<button class="btn btn-info" onclick="window.location.href=\'/blog/detail/' + blog.id + '\'">Chi tiết</button>' +
                                '</div>' +
                                '</td>' +
                                '</tr>');
                        }
                    });

                    currentPage++;
                    $('#currentPage').val(currentPage);
                    isLoading = false;
                } else {
                    $('#loadMore').hide();
                }
            },
            error: function() {
                alert('Đã xảy ra lỗi khi tải dữ liệu.');
                isLoading = false;
            }
        });
    }

    $('#loadMore').click(function() {
        loadBlogs(currentPage);
    });


    // Xóa bài viết
    $('#blogTable').on('click', '.deleteBlogButton', function() {
        var id = $(this).data('id');
        if (confirm('Bạn có chắc chắn muốn xóa blog này?')) {
            $.ajax({
                url: '/blog/delete/' + id,
                type: 'POST',
                success: function() {
                    alert('Xóa thành công!');
                    location.reload();
                }
            });
        }
    });

    // Thêm bài viết
    $('#createBtn').click(function(event) {
        $('#createBtn').click(function(event) {
            event.preventDefault();

            var blogData = {
                name: $('#name').val(),
                author: $('#author').val(),
                title: $('#title').val(),
                content: $('#content').val(),
                category: $('#category').val()
            };

            $.ajax({
                url: '/blog/create',
                type: 'POST',
                contentType: 'application/json',
                data: JSON.stringify(blogData),
                success: function(response) {
                    alert('Thêm mới blog thành công!');
                    window.location.href = '/blog';
                },
                error: function(error) {
                    alert('Có lỗi xảy ra khi thêm mới blog. Vui lòng thử lại!');
                    console.log(error);
                }
            });
        });
    });

    // Cập nhật bài viết
    $('#updateBtn').click(function(event) {
        event.preventDefault();
        var formData = $('#updateBlogForm').serialize();
        $.ajax({
            url: '/blog/update',
            type: 'POST',
            data: formData,
            success: function(response) {
                alert('Cập nhật thành công!');
                window.location.href = '/blog';
            }
        });
    });
});