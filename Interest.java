package lab2;

import java.math.BigDecimal;

public class Interest {
	private double annualInterestRate;
	private int periodsPerYear = 0;
	private double totalInvestmentYears;
	public Interest(double annualInterestRate, double totalInvestmentYears) 
	{
		this.annualInterestRate = annualInterestRate;
		this.totalInvestmentYears = totalInvestmentYears;
	}
	public Interest(double annualInterestRate, double totalInvestmentYears, int periodsPerYear) 
	{
		this.annualInterestRate = annualInterestRate;
		this.totalInvestmentYears = totalInvestmentYears;
		this.periodsPerYear = periodsPerYear;
	}
	public boolean isCompound() 
	{
		return this.periodsPerYear != 0;
	}
	public BigDecimal Calculate(BigDecimal principal)
	{
		if (this.isCompound())
		{
			double base = 1 + annualInterestRate / periodsPerYear;
			double exponent = periodsPerYear * totalInvestmentYears;
			BigDecimal multiplicand = BigDecimal.valueOf(Math.pow(base, exponent));
			
			return principal.multiply(multiplicand);
		}
		else
		{
			BigDecimal multiplicand = BigDecimal.valueOf(annualInterestRate*totalInvestmentYears);
			return principal.multiply(multiplicand);
		}
	}
	public double Calculate(double principal)
	{
		return this.Calculate(BigDecimal.valueOf(principal)).doubleValue();
	}
	
}
