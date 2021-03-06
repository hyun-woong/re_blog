function searchParam(key){
    return new URLSearchParams(location.search).get(key);
}
let id = searchParam('id');

$(document).ready(function () {
    // HTML 문서를 로드할 때마다 실행합니다.
    getMessages(id);
})

// 메모를 불러와서 보여줍니다.
function getMessages(id) {
    // 1. 기존 메모 내용을 지웁니다.
    $('#main_post_box').empty();
    // 2. 메모 목록을 불러와서 HTML로 붙입니다.
    $.ajax({
        type: 'GET',
        url: `/api/mainPost/${id}`,
        success: function (response) {
            console.log(response);
                let blog = response;
                let id = blog.id;
                let title = blog.title;
                let username = blog.username;
                let contents = blog.contents;
                let modifiedAt = blog.modifiedAt;
                let tempHtml = `
             <div class="main-post">
    <article class="message is-dark">
      <div class="message-header">
        <p>${title}</p>
        <button onclick="back_page()" class="delete" aria-label="delete"></button>
      </div>
      <div class="dateTime">
        <article class="message is-dark">
          <div id="id-username" class="message-body">
            📝 글쓴이 ${username}<span class="time_text">⏳️ ${modifiedAt}</span>
          </div>
        </article>
      </div>

      <article class="message is-dark">
        <div class="message-body">
          ${contents}
     <!--        삭제버튼-->
         <div class="delete_btn" onclick="deleteOne('${id}')" id="${id}-delete">
            <button class="button is-black" >삭제하기</button>
         </div>     
        </div>

       
      </article>
    </article>
  </div>
       `;
            $('#main_post_box').append(tempHtml);
        }
    })
//메인페이지로 돌아가기
}

function deleteOne(id) {
    // 1. DELETE /api/memos/{id} 에 요청해서 메모를 삭제합니다.
        $.ajax({
            type: "DELETE",
            url: `/api/mainPost/${id}`,
            success: function (response) {
                alert('메시지 삭제에 성공하였습니다.');
                window.location.href = '../index.html';
            }
        })
}

function back_page(){
    window.location.href = '../index.html';
}