# Encryptor
Public library to encrypt and decrypt data.

Español:

	Esta libreria fue creada con el proposito de encriptar los datos de tipo char[] de el componente JPassword.
		
		- metodos 
	
			+ encryptData (char[], SecretKey, Cipher). return byte[]:
			
				Utiliza este metodo para encriptar un dato Este metodo devolvera un dato del tipo byte[] con los datos encriptados.
				Es importante que guardes la SecretKey para luego desencriptar los datos.
			
				Ej: "Encryptor.encryptData(data, key, cipher)".
				
			+ decryptData (byte[], SecretKey, Cipher) . return String:
			
				Utiliza este metodo para desencriptar los datos, encriptados anteriormente con el metodo "encryptData".
				Es importante que utilices la misma SecretKey que utilizaste para encriptar los datos.
				
				Ej: "Encryptor.decryptData(data, key, cipher)".
				
			+ keyGen(). return SecretKey:
				
				Utiliza este metodo para generar una SecretKey para el dato que deseas encriptar.
				Es importatne utilizar esta función ya que utiliza el algoritmo "AES" para el crifrado.
				
			+ cipherGen(). return Cipher:
			
				Utiliza este metodo para generar un Cipher para el dato que deseas encriptar.
				Es importante utilizar esta función ya que utiliza el algoritmo "AES" para el crifrado.
				
		
