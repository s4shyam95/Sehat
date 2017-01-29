$(document).ready(function () {
    $('#left').scrollTop($('#left').prop('scrollHeight'));

	$("#addPresc").click(function () {
		if($('#addPresc').val() == "+") {
			$('#prescText').removeClass('hidden');
			$('#addPresc').val('Done');
		}
		else {
			$('#addPresc').val('+');
			$('#prescText').addClass('hidden');
			if($('#prescTB').val() !== ""){
				var presc = "<div class='presc'><p>".concat($('#prescTB').val(), "</p><div class='check'> <input type='checkbox' value='m' id='mcb'> <input type='checkbox' value='a' id='acb'> <input type='checkbox' value='n' id='ncb'></div></div>");
				$('#prescriptions').append(presc);
			}	
			$('#prescTB').val('');
		}
	});
	$('#sendBut').click(function () {
		$('#dataForm').attr('value', $('#msgBox').val());
		$('#sendSubmit').click();
	});
	$('#saveBut').click(function () {
		$('#sympForm').attr('value', $('#sympBox').val());
		$('#diagForm').attr('value', $('#diagBox').val());
		var presc = null;
		$('#prescriptions').children('.presc').each(function () {
			if(!presc) {
				presc = $(this).children('p').text();
				presc += '-';
				$(this).children('.check').children('input[type=checkbox]:checked').each(function() {
					presc += $(this).attr('value');
				});

			} else {
				presc += ',';
				presc += $(this).children('p').text();
				presc += '-';
				$(this).children('.check').children('input[type=checkbox]:checked').each(function() {
					presc += $(this).attr('value');
				});
			}
		});
		$('#prescForm').attr('value', presc);
		$('#saveSubmit').click();
	});
});