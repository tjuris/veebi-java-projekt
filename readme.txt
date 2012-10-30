Eclipse'i tÃµmbamine:
	-file->import->projects from git->uri
	-tÃ¤ita valitud vÃ¤ljad ning valida next kuni tuleb project wizard vÃ¤li
	-valida import as general project
	-tekkinud projekti peal paremklikk, configure -> convert to faceted form
	-avanenud aknast valida dynamic web module ja JPA facetid
	-seejÃ¤rel teha ant retrieve projekti build.xml failist
	-projekti lib/build/ kaustast leida javax.servlet-api... fail ning paremklikiga Build Path -> add to build path 
	-errorid peaksid kaduma ja asjad kenasti serveril kÃ¤ivituma
	
	
	lihtsalt testiks lisatud rida, et teada saada kas nüüd lõpuks asi töötab