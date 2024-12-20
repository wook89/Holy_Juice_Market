<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style>
   label {
            font-size: 16px;
        }
        .radio-group {
        }
</style>
	<form>
        <div class="radio-group">
        	<label>
                <input type="radio"  value="all" onclick="navigateToSelect(this.value)"> 전체 &nbsp;&nbsp;
            </label>
            <label>
                <input type="radio"  value="juice" onclick="navigateToSelect(this.value)"> 액상 &nbsp;&nbsp;
            </label>
            <label>
                <input type="radio"  value="vape" onclick="navigateToSelect(this.value)"> 기기 &nbsp;&nbsp;
            </label>
            <label>
                <input type="radio"  value="pot" onclick="navigateToSelect(this.value)"> 팟 &nbsp;&nbsp;
            </label>
        </div>
    </form>
