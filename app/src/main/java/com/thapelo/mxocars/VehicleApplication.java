package com.thapelo.mxocars;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;


// User puts information and send it through an email.


public class VehicleApplication extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String maritalStatus;
    String graduateStatus;
    String homeOwnerStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_vehicle_application );
        final MediaPlayer mediaPlayer3 = MediaPlayer.create( this, R.raw.before_sending );
        // Switch if user is married and get input
        Spinner maritalSpinner = findViewById( R.id.marital_questions_spinner );
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> maritalAdapter = ArrayAdapter.createFromResource( this, R.array.marital_status_array, R.layout.custom_spinner_string );
        // Specify the layout to use when the list of choices appears
        maritalAdapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
        // Apply the adapter to the spinner
        maritalSpinner.setAdapter( maritalAdapter );
        // attach set on item selected listener
        maritalSpinner.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (parent.getId() == R.id.marital_questions_spinner) {
                    maritalStatus = parent.getItemAtPosition( position ).toString();

                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // What do you want to do if the user doesn't click

            }
        } );


        // Switch if user is a graduate and get input
        Spinner graduateSpinner = findViewById( R.id.graduate_questions_spinner );
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> graduateAdapter = ArrayAdapter.createFromResource( this, R.array.graduate_status_array, R.layout.custom_spinner_string );
        // Specify the layout to use when the list of choices appears
        graduateAdapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
        // Apply the adapter to the spinner
        graduateSpinner.setAdapter( graduateAdapter );
        // attach set on item selected listener
        graduateSpinner.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (parent.getId() == R.id.graduate_questions_spinner) {
                    graduateStatus = parent.getItemAtPosition( position ).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // What do you want to do if the user doesn't click

            }
        } );


        Spinner homeOwnerSpinner = findViewById( R.id.home_questions_spinner );
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> homeOwnerAdapter = ArrayAdapter.createFromResource( this, R.array.homeowner_status_array, R.layout.custom_spinner_string );
        // Specify the layout to use when the list of choices appears
        homeOwnerAdapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
        // Apply the adapter to the spinner
        homeOwnerSpinner.setAdapter( homeOwnerAdapter );
        // attach set on item selected listener
        homeOwnerSpinner.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (parent.getId() == R.id.home_questions_spinner) {
                    homeOwnerStatus = parent.getItemAtPosition( position ).toString();
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // What do you want to do if the user doesn't click


            }
        } );
        // Send Application button
        AppCompatButton sendApplication = findViewById( R.id.send_button );

        sendApplication.setOnClickListener( v -> {

            // Get user surname
            EditText surname = findViewById( R.id.surname_edit );
            Editable userSurname = surname.getText();
            String theSurname = userSurname.toString();
            // Get user name
            EditText fullName = findViewById( R.id.full_names_edit );
            Editable userName = fullName.getText();
            String theName = userName.toString();
            // Get user id number
            EditText idNumber = findViewById( R.id.id_edit );
            Editable userId = idNumber.getText();
            String theId = userId.toString();


            // Get user landline number
            EditText landline = findViewById( R.id.landline_edit );
            Editable userLandLine = landline.getText();
            String theLandline = userLandLine.toString();


            // Get user cell number
            EditText cellNumber = findViewById( R.id.cell_phone_edit );
            Editable userCellNumber = cellNumber.getText();
            String theCellNumber = userCellNumber.toString();


            // Get user email
            EditText email = findViewById( R.id.email_edit );
            Editable userEmail = email.getText();
            String theEmail = userEmail.toString();
            // Get user home address
            EditText homeAddress = findViewById( R.id.home_address_edit );
            Editable userHomeAddress = homeAddress.getText();
            String theHomeAddress = userHomeAddress.toString();
            // Get user postal code
            EditText postalCode = findViewById( R.id.postal_code_edit );
            Editable userPostalCode = postalCode.getText();
            String thePostalCode = userPostalCode.toString();


            // Get user years of residence
            EditText yearsLivingThere = findViewById( R.id.years_residing_edit );
            Editable userResidingYears = yearsLivingThere.getText();
            String theYearsResiding = userResidingYears.toString();

            // Get user postal address
            EditText postalAddress = findViewById( R.id.postal_address_edit );
            Editable userPostalAddress = postalAddress.getText();
            String thePostalAddress = userPostalAddress.toString();
            // Switch if user is a home owner and get input
            // Switch if user is a home owner and get input

            // Get user employers name
            EditText employersName = findViewById( R.id.employer_name_edit );
            Editable userEmployerName = employersName.getText();
            String theEmployerName = userEmployerName.toString();
            // Get user contact
            EditText employersContact = findViewById( R.id.employers_contact_edit );
            Editable userEmployersContact = employersContact.getText();
            String theEmployerContact = userEmployersContact.toString();

            // Get user employers address
            EditText employerAddress = findViewById( R.id.employers_address_edit );
            Editable userEmployerAddress = employerAddress.getText();
            String theEmployersAddress = userEmployerAddress.toString();
            // Get users years of employment
            EditText numberOfYearsEmployed = findViewById( R.id.years_employed_edit );
            Editable userYearsEmployed = numberOfYearsEmployed.getText();
            String theEmployedNumberOfYears = userYearsEmployed.toString();


            // Get users occupation
            EditText occupation = findViewById( R.id.occupation_edit );
            Editable userOccupation = occupation.getText();
            String theOccupation = userOccupation.toString();

            // Get users industry
            EditText typeOfIndustry = findViewById( R.id.industry_edit );
            Editable userTypeOfIndustry = typeOfIndustry.getText();
            String theIndustryType = userTypeOfIndustry.toString();
            // Get users bank
            EditText bank = findViewById( R.id.bank_edit );
            Editable userBank = bank.getText();
            String theBank = userBank.toString();
            // Get users bank account number
            EditText bankAccountNumber = findViewById( R.id.bank_account_number_edit );
            Editable userBankAccount = bankAccountNumber.getText();
            String theBankAccount = userBankAccount.toString();


            // Get users bank branch code
            EditText bankBranchCode = findViewById( R.id.bank_branch_code_edit );
            Editable userBankBranchCode = bankBranchCode.getText();
            String theBankBranchCode = userBankBranchCode.toString();


            // Get users spouse contacts
            EditText spouseContact = findViewById( R.id.spouse_contact_number_edit );
            Editable userSpouseContact = spouseContact.getText();
            String theSpouseContact = userSpouseContact.toString();


            // Get users spouse id number
            EditText spouseId = findViewById( R.id.spouse_id );
            Editable userSpouseId = spouseId.getText();
            String theSpouseId = userSpouseId.toString();


            // Get what users relationship with relative
            EditText relatedHow = findViewById( R.id.relationship_edit );
            Editable userRelatedHow = relatedHow.getText();
            String theRelation = userRelatedHow.toString();
            // Get users relative contacts
            EditText contactRelative = findViewById( R.id.relative_phone_edit );
            Editable userRelativeContacts = contactRelative.getText();
            String theRelativeContact = userRelativeContacts.toString();


            // Get users relative name
            EditText relativeName = findViewById( R.id.relative_full_name_edit );
            Editable userRelativeName = relativeName.getText();
            String theRelativeName = userRelativeName.toString();
            // Get users relative surname
            EditText relativeSurname = findViewById( R.id.surname_relative_edit );
            Editable userRelativeSurname = relativeSurname.getText();
            String theRelativeSurname = userRelativeSurname.toString();
            // Get users relative name
            EditText relativeAddress = findViewById( R.id.relative_address_edit );
            Editable userRelativeAddress = relativeAddress.getText();
            String theRelativeAddress = userRelativeAddress.toString();

            // Get users gross
            EditText gross = findViewById( R.id.gross_edit );
            Editable userGross = gross.getText();
            String theGross = userGross.toString();


            // Get users net
            EditText net = findViewById( R.id.net_edit );
            Editable userNet = net.getText();
            String theNet = userNet.toString();


            // Get additional income
            EditText additionalIncome = findViewById( R.id.additional_income_status );
            Editable userAdditionalIncome = additionalIncome.getText();
            String addedIncomeStatus = userAdditionalIncome.toString();


            // Get users source of income
            EditText sourceOfIncome = findViewById( R.id.source_of_edit );
            Editable userSourceIncome = sourceOfIncome.getText();
            String theSourceOfIncome = userSourceIncome.toString();
            // Get users house hold expense cost
            EditText hHoldExpenses = findViewById( R.id.household_expenses_edit );
            Editable userHHoldExpenses = hHoldExpenses.getText();
            String theHHExpenses = userHHoldExpenses.toString();


            // Get users education cost
            EditText education = findViewById( R.id.education_fees_edit );
            Editable userEducation = education.getText();
            String theEducation = userEducation.toString();


            // Get users maintenance cost
            EditText maintenance = findViewById( R.id.maintenance_edit );
            Editable userMaintenance = maintenance.getText();
            String theMaintenance = userMaintenance.toString();


            // Get users food and entertainment cost
            EditText entertainment = findViewById( R.id.food_or_entertainment_edit );
            Editable userEntertainment = entertainment.getText();
            String theEntertainment = userEntertainment.toString();


            // Get users credit card cost
            EditText creditCard = findViewById( R.id.credit_card_edit );
            Editable userCreditCard = creditCard.getText();
            String theCreditCard = userCreditCard.toString();


            // Get users phone bill
            EditText phoneAcc = findViewById( R.id.phone_bill_edit );
            Editable userPhoneAcc = phoneAcc.getText();
            String thePhoneAcc = userPhoneAcc.toString();


            // Get users over draft
            EditText overdraft = findViewById( R.id.overdraft_edit );
            Editable userOverDraft = overdraft.getText();
            String theOverDraft = userOverDraft.toString();


            // Get users clothing account cost
            EditText clothingAcc = findViewById( R.id.clothing_account_edit );
            Editable userClothingAcc = clothingAcc.getText();
            String theClothingAcc = userClothingAcc.toString();


            // Get users municipality cost
            EditText municipality = findViewById( R.id.municipality_edit );
            Editable userMunicipality = municipality.getText();
            String theMunicipality = userMunicipality.toString();

            // Get users transport cost
            EditText transport = findViewById( R.id.transport_edit );
            Editable userTransport = transport.getText();
            String theTransport = userTransport.toString();


            // Get users bond cost
            EditText rent = findViewById( R.id.bond_rent_edit );
            Editable userRent = rent.getText();
            String theRent = userRent.toString();


            // Get users personal loan cost
            EditText personalLoans = findViewById( R.id.personal_loans_edit );
            Editable userPersonalLoans = personalLoans.getText();
            String thePersonalLoan = userPersonalLoans.toString();
            // Get users spouse name
            EditText spouseName = findViewById( R.id.spouse_name );
            Editable userSpouseName = spouseName.getText();
            String theSpouseName = userSpouseName.toString();

            // Get users spouse surname
            EditText spouseSurname = findViewById( R.id.spouse_surname );
            Editable userSpouseSurname = spouseSurname.getText();
            String theSpouseSurname = userSpouseSurname.toString();
            // Get users insurance
            EditText insurance = findViewById( R.id.insurance_edit );
            Editable userInsurance = insurance.getText();
            String theInsurance = userInsurance.toString();

            // Get users other expenses
            EditText otherExpenses = findViewById( R.id.other_expenses_edit );
            Editable userOtherExpenses = otherExpenses.getText();
            String theOtherExpenses = userOtherExpenses.toString();

            // display message
            String message = createInformation( theSurname, theName, theId, theCellNumber, theEmail, theLandline, maritalStatus, graduateStatus, theHomeAddress, thePostalCode, theYearsResiding, thePostalAddress, homeOwnerStatus, theEmployerName, theEmployerContact, theEmployersAddress, theEmployedNumberOfYears, theOccupation, theIndustryType, theBank, theBankAccount, theBankBranchCode, theSpouseName, theSpouseSurname, theSpouseId, theSpouseContact, theRelation, theRelativeName, theRelativeSurname, theRelativeAddress, theRelativeContact, theGross, theNet, addedIncomeStatus, theSourceOfIncome, thePersonalLoan, theInsurance, theRent, theMunicipality, theCreditCard, theClothingAcc, theOverDraft, thePhoneAcc, theTransport, theEntertainment, theEducation, theMaintenance, theHHExpenses, theOtherExpenses );
            // Use an intent to launch an email app.
            // Send the createInformation in the email body.
            Intent emailIntent = new Intent( Intent.ACTION_SENDTO );
            emailIntent.setData( Uri.parse( "mailto:" ) ); // only email apps should handle this
            emailIntent.putExtra( Intent.EXTRA_EMAIL, new String[]{"mxolisin@mcmotor.com"} );
            emailIntent.putExtra( Intent.EXTRA_SUBJECT, getString( R.string.vehicle_finance_application_for, theSurname ) );
            emailIntent.putExtra( Intent.EXTRA_TEXT, message );
            emailIntent.addFlags( Intent.FLAG_ACTIVITY_NEW_TASK ); // this will make such that when user returns to your app, your app is displayed, instead of the email app.
            if (emailIntent.resolveActivity( getPackageManager() ) != null) {
                startActivity( emailIntent );

            }
            mediaPlayer3.start();


        } );
    }

    /**
     * @param theSurname               - The surname of the user
     * @param theName                  - The name of the user
     * @param theId                    - The id of the user
     * @param theCellNumber            - The cell phone number of the user
     * @param theEmail                 - The email address of the user
     * @param theLandline              - The landline of the user
     * @param maritalStatus            - Is the user married
     * @param graduateStatus           - Is the user a graduate
     * @param theHomeAddress           - The home address of the user
     * @param thePostalCode            - The postal code of the user
     * @param theYearsResiding         - The years residing of the user
     * @param thePostalAddress         - The postal address of the user
     * @param homeOwnerStatus          - is the user a home owner
     * @param theEmployerName          - The employer name of the user
     * @param theEmployerContact       - The employers contact of the user
     * @param theEmployersAddress      - The employer address of the user
     * @param theEmployedNumberOfYears - The number of year residing of the user
     * @param theOccupation            - The occupation of the user
     * @param theIndustryType          _ The industry of the user
     * @param theBank                  - The bank name of the user
     * @param theBankAccount           - The bank account number of the user
     * @param theBankBranchCode        - The bank branch code of the user
     * @param theSpouseName            - The spouse name of the user
     * @param theSpouseSurname         - The spouse surname of the user
     * @param theSpouseId              - The spouse id number of the user
     * @param theSpouseContact         - The spouse contact number of the user
     * @param theRelation              - The relationship of relative of the user
     * @param theRelativeName          - The relative name of the user
     * @param theRelativeSurname       - The relative surname of the user
     * @param theRelativeAddress       - The relative address of the user
     * @param theRelativeContact       - The contact of the relative of the user
     * @param theGross                 - The gross of the user
     * @param theNet                   - The net of the user
     * @param addedIncomeStatus        - Does the user have extra income?
     * @param theSourceOfIncome        - The source of the user
     * @param thePersonalLoan          - The personal loan of the user
     * @param theInsurance             - The insurance of the user
     * @param theRent                  - The rent / bond cost of the user
     * @param theMunicipality          - Municipality charges of the user
     * @param theCreditCard            - The credit card bill of the user
     * @param theClothingAcc           - The clothing account of the user
     * @param theOverDraft             - The bank over draft of the user
     * @param thePhoneAcc              - The phone account bill of the user
     * @param theTransport             - The transport cost of the user
     * @param theEntertainment         - The entertainment and food cost of the user
     * @param theEducation             - The education cost of the user
     * @param theMaintenance           - The maintenance cost of the user
     * @param theHHExpenses            - The household expenses of the user
     * @param theOtherExpenses         - Additional Expenses of the user
     * @return - User information
     */
    private String createInformation(String theSurname, String theName, String theId, String theCellNumber, String theEmail, String theLandline, String maritalStatus, String graduateStatus, String theHomeAddress, String thePostalCode, String theYearsResiding, String thePostalAddress, String homeOwnerStatus, String theEmployerName, String theEmployerContact, String theEmployersAddress, String theEmployedNumberOfYears, String theOccupation, String theIndustryType, String theBank, String theBankAccount, String theBankBranchCode, String theSpouseName, String theSpouseSurname, String theSpouseId, String theSpouseContact, String theRelation, String theRelativeName, String theRelativeSurname, String theRelativeAddress, String theRelativeContact, String theGross, String theNet, String addedIncomeStatus, String theSourceOfIncome, String thePersonalLoan, String theInsurance, String theRent, String theMunicipality, String theCreditCard, String theClothingAcc, String theOverDraft, String thePhoneAcc, String theTransport, String theEntertainment, String theEducation, String theMaintenance, String theHHExpenses, String theOtherExpenses) {
        //displayInformation += String.format(  R.string.name + theName  );
        String displayInformation = getString( R.string.surname, ": " + theSurname );
        displayInformation += "\n" + getString( R.string.name, ": " + theName );
        displayInformation += "\n" + getString( R.string.id_number, ": " + theId );
        displayInformation += "\n" + getString( R.string.cell_number, ": " + theCellNumber );
        displayInformation += "\n" + getString( R.string.email, ": " + theEmail );
        displayInformation += "\n" + getString( R.string.land_line, ": " + theLandline );
        displayInformation += "\n" + getString( R.string.are_you_married, ": " + maritalStatus );
        displayInformation += "\n" + getString( R.string.are_you_a_graduate, ": " + graduateStatus );
        displayInformation += "\n" + getString( R.string.home_address, ": " + theHomeAddress );
        displayInformation += "\n" + getString( R.string.postal_code, ": " + thePostalCode );
        displayInformation += "\n" + getString( R.string.how_many_years_have_you_been_living_there, ": " + theYearsResiding + " years" );
        displayInformation += "\n" + getString( R.string.postal_address, ": " + thePostalAddress );
        displayInformation += "\n" + getString( R.string.are_you_a_home_owner, ": " + homeOwnerStatus );
        displayInformation += "\n" + getString( R.string.employers_name, ": " + theEmployerName );
        displayInformation += "\n" + getString( R.string.employers_contact, ": " + theEmployerContact );
        displayInformation += "\n" + getString( R.string.employers_address, ": " + theEmployersAddress );
        displayInformation += "\n" + getString( R.string.number_of_years_employed, ": " + theEmployedNumberOfYears + " years" );
        displayInformation += "\n" + getString( R.string.occupation, ": " + theOccupation );
        displayInformation += "\n" + getString( R.string.industry, ": " + theIndustryType );
        displayInformation += "\n" + getString( R.string.bank, ": " + theBank );
        displayInformation += "\n" + getString( R.string.bank_account_number, ": " + theBankAccount );
        displayInformation += "\n" + getString( R.string.bank_branch, ": " + theBankBranchCode );
        displayInformation += "\n" + getString( R.string.spouse_contact_number, ": " + theSpouseContact );
        displayInformation += "\n" + getString( R.string.spouse_id_number, ": " + theSpouseId );
        displayInformation += "\n" + getString( R.string.spouse_name, ": " + theSpouseName );
        displayInformation += "\n" + getString( R.string.spouse_surname, ": " + theSpouseSurname );
        displayInformation += "\n" + getString( R.string.relationship_of_relative, ": " + theRelation );
        displayInformation += "\n" + getString( R.string.full_names_of_relative, ": " + theRelativeName );
        displayInformation += "\n" + getString( R.string.surname_of_relative, ": " + theRelativeSurname );
        displayInformation += "\n" + getString( R.string.address_of_relative, ": " + theRelativeAddress );
        displayInformation += "\n" + getString( R.string.phone_number_of_relative, ": " + theRelativeContact );
        displayInformation += "\n" + getString( R.string.gross, ": R " + theGross );
        displayInformation += "\n" + getString( R.string.net_income, ": R " + theNet );
        displayInformation += "\n" + getString( R.string.do_you_have_additional_income, ": " + addedIncomeStatus );
        displayInformation += "\n" + getString( R.string.source_of_additional_income, ": " + theSourceOfIncome );
        displayInformation += "\n" + getString( R.string.personal_loan, ": R " + thePersonalLoan );
        displayInformation += "\n" + getString( R.string.insurance, ": R " + theInsurance );
        displayInformation += "\n" + getString( R.string.bond_or_renting, ": R " + theRent );
        displayInformation += "\n" + getString( R.string.municipality, ": R " + theMunicipality );
        displayInformation += "\n" + getString( R.string.credit_card, ": R " + theCreditCard );
        displayInformation += "\n" + getString( R.string.clothing_account, ": R " + theClothingAcc );
        displayInformation += "\n" + getString( R.string.overdraft, ": R " + theOverDraft );
        displayInformation += "\n" + getString( R.string.phone_account, ": R " + thePhoneAcc );
        displayInformation += "\n" + getString( R.string.transport, ": R " + theTransport );
        displayInformation += "\n" + getString( R.string.food_or_entertainment, ": R " + theEntertainment );
        displayInformation += "\n" + getString( R.string.education_fees, ": R " + theEducation );
        displayInformation += "\n" + getString( R.string.maintenance, ": R " + theMaintenance );
        displayInformation += "\n" + getString( R.string.household_expenses, ": R " + theHHExpenses );
        displayInformation += "\n" + getString( R.string.other_expenses, ": R " + theOtherExpenses );
        return displayInformation;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}










