$(document).ready(function () {
	$('.unanswered').click(function () {
		$this = $(this);
		id = $this.attr('tag');
		console.log(id);
		window.location.href = "/query/?id="+id;
	});
});