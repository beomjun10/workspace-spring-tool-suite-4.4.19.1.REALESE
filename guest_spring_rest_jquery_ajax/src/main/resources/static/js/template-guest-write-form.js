
export function guest_write_form() {
	let htmlTemplate =
		`
		<table width="0" border="0" cellpadding="0" cellspacing="0">
			<tbody>
				<tr>
					<td>
						<!--contents--> <br>
						<table style="padding-left: 10px" border="0" cellpadding="0" cellspacing="0">
							<tbody>
								<tr>
									<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>방명록 관리 -
											방명록 쓰기</b></td>
								</tr>
							</tbody>
						</table> <!-- guest write Form  -->
						<form id="guest_write_form" name="f" method="post">
							<table border="0" cellpadding="0" cellspacing="1" width="590" bgcolor="BBBBBB">
								<tbody>
									<tr>
										<td width="100" align="center" bgcolor="E6ECDE" height="22">이름</td>
										<td width="490" align="left" bgcolor="ffffff" style="padding-left: 10px"><input
												type="text" style="width: 150" name="guest_name" value="{{guest_name}}"></td>
									</tr>
									<tr>
										<td width="100" align="center" bgcolor="E6ECDE" height="22">이메일</td>
										<td width="490" align="left" bgcolor="ffffff" style="padding-left: 10px"><input
												type="text" style="width: 150" name="guest_email"></td>
									</tr>
									<tr>
										<td width="100" align="center" bgcolor="E6ECDE" height="22">홈페이지</td>
										<td width="490" align="left" bgcolor="ffffff" style="padding-left: 10px"><input
												type="text" style="width: 150" name="guest_homepage"></td>
									</tr>
									<tr>
										<td width="100" align="center" bgcolor="E6ECDE" height="22">타이틀</td>
										<td width="490" align="left" bgcolor="ffffff" style="padding-left: 10px"><input
												type="text" style="width: 240" name="guest_title"></td>
									</tr>
									<tr>
										<td width="100" align="center" bgcolor="E6ECDE" height="22">내용</td>
										<td width="490" align="left" bgcolor="ffffff" style="padding-left: 10px">
											<textarea wrap="soft" style="width: 240px" rows="10"
												name="guest_content"></textarea>
										</td>
									</tr>
								</tbody>
							</table>
						</form> <br>
						<table width="590" border="0" cellpadding="0" cellspacing="0">
							<tbody>
								<tr>
									<td align="center"><input type="button" data-navigate="/guest_write_action" value="방명록쓰기" id="btn_guest_write_action">
										&nbsp; <input type="button" data-navigate="/guest_list" id="btn_guest_list" value="방명록목록"></td>
								</tr>
							</tbody>
						</table>
					</td>
				</tr>
			</tbody>
		</table>
		`;
	let bindTemplate = Handlebars.compile(htmlTemplate);
	let resultTemplate = bindTemplate({});
	return resultTemplate;
}
