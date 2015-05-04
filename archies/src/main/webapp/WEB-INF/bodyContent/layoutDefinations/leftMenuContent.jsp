<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script>
	$(function(){
		$('.listRootLink').on('click', function(){
			var iTag = $(this).children('b').children('i');
			iTag.toggleClass('fa-caret-right');
			iTag.toggleClass('fa-caret-down');
			/* var iTagSelector = $(this).attr('href')+'Caret';
			$(iTagSelector).toggleClass('fa-caret-right');
			$(iTagSelector).toggleClass('fa-caret-down'); */
		});
	});
</script>
<div class="list-group col-sm-2 col-md-3">

	<a class="tree-toggler nav-header list-group-item listRootLink" data-toggle="collapse" href="#collapseMerchantTxns" aria-expanded="true">
		<b>Merchant and Transactions<i id="collapseMerchantTxnsCaret" style="float:right" class="fa fa-caret-down"></i></b>
	</a>
	<div  id="collapseMerchantTxns" class="collapse in listRoot">
		<a href="<c:url value='merchant/merchantsMain'/>" id="manageMerchantMI" class="list-group-item mItem"><i class="fa fa-users"></i> Manage Merchants</a>
		<a href="<c:url value='transaction/transactionsMain'/>" id="debitCreditMI" class="list-group-item mItem"><i class="fa fa-pencil-square"></i> Manage Debit/Credit</a>
		<a href="<c:url value='transaction/transactionsSearchMain'/>" id="transactionsSearchMI" class="list-group-item mItem"><i class="fa fa-search"></i> Search Transactions</a>
	</div>
	
	<a class="tree-toggler nav-header list-group-item listRootLink" data-toggle="collapse" href="#collapseDailyTxns" aria-expanded="true">
		<b>Daily Transactions<i id="collapseDailyTxnsCaret" style="float:right" class="fa fa-caret-down"></i></b>
	</a>
	<div  id="collapseDailyTxns" class="collapse in listRoot">
		<a href="<c:url value='dailyTransaction/dailyTransactionsMain'/>" id="dailyDebitCreditMI" class="list-group-item mItem"><i class="fa fa-pencil-square-o"></i> Manage Debit/Credit</a>
	</div>
	
	<a class="tree-toggler nav-header list-group-item listRootLink" data-toggle="collapse" href="#collapseChangePassword" aria-expanded="true">
		<b>Settings<i id="collapseChangePasswordCaret" style="float:right" class="fa fa-caret-down"></i></b>
	</a>
	<div  id="collapseChangePassword" class="collapse in listRoot">
		<a href="<c:url value='/changePasswordForm'/>" id="changePasswordMI" class="list-group-item mItem"><i class="fa fa-lock"></i> Change Password</a>
	</div>

</div>