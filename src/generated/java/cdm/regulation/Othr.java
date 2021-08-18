package cdm.regulation;

import cdm.regulation.meta.OthrMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaClass

public interface Othr extends RosettaModelObject {
	Othr build();
	Othr.OthrBuilder toBuilder();
	
	/**
	 */
	DerivInstrmAttrbts getDerivInstrmAttrbts();
	/**
	 */
	FinInstrmGnlAttrbts getFinInstrmGnlAttrbts();
	/**
	 */
	String getId();
	/**
	 */
	SchmeNm getSchmeNm();
	final static OthrMeta metaData = new OthrMeta();
	
	@Override
	default RosettaMetaData<? extends Othr> metaData() {
		return metaData;
	} 
			
	static Othr.OthrBuilder builder() {
		return new Othr.OthrBuilderImpl();
	}
	
	default Class<? extends Othr> getType() {
		return Othr.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		
		processRosetta(path.newSubPath("derivInstrmAttrbts"), processor, DerivInstrmAttrbts.class, getDerivInstrmAttrbts());
		processRosetta(path.newSubPath("finInstrmGnlAttrbts"), processor, FinInstrmGnlAttrbts.class, getFinInstrmGnlAttrbts());
		processRosetta(path.newSubPath("schmeNm"), processor, SchmeNm.class, getSchmeNm());
	}
	
	
	interface OthrBuilder extends Othr, RosettaModelObjectBuilder {
		DerivInstrmAttrbts.DerivInstrmAttrbtsBuilder getOrCreateDerivInstrmAttrbts();
		DerivInstrmAttrbts.DerivInstrmAttrbtsBuilder getDerivInstrmAttrbts();
		FinInstrmGnlAttrbts.FinInstrmGnlAttrbtsBuilder getOrCreateFinInstrmGnlAttrbts();
		FinInstrmGnlAttrbts.FinInstrmGnlAttrbtsBuilder getFinInstrmGnlAttrbts();
		SchmeNm.SchmeNmBuilder getOrCreateSchmeNm();
		SchmeNm.SchmeNmBuilder getSchmeNm();
		Othr.OthrBuilder setDerivInstrmAttrbts(DerivInstrmAttrbts derivInstrmAttrbts);
		Othr.OthrBuilder setFinInstrmGnlAttrbts(FinInstrmGnlAttrbts finInstrmGnlAttrbts);
		Othr.OthrBuilder setId(String id);
		Othr.OthrBuilder setSchmeNm(SchmeNm schmeNm);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			
			processRosetta(path.newSubPath("derivInstrmAttrbts"), processor, DerivInstrmAttrbts.DerivInstrmAttrbtsBuilder.class, getDerivInstrmAttrbts());
			processRosetta(path.newSubPath("finInstrmGnlAttrbts"), processor, FinInstrmGnlAttrbts.FinInstrmGnlAttrbtsBuilder.class, getFinInstrmGnlAttrbts());
			processRosetta(path.newSubPath("schmeNm"), processor, SchmeNm.SchmeNmBuilder.class, getSchmeNm());
		}
		
	}
	
	//Othr.OthrImpl
	class OthrImpl implements Othr {
		private final DerivInstrmAttrbts derivInstrmAttrbts;
		private final FinInstrmGnlAttrbts finInstrmGnlAttrbts;
		private final String id;
		private final SchmeNm schmeNm;
		
		protected OthrImpl(Othr.OthrBuilder builder) {
			this.derivInstrmAttrbts = ofNullable(builder.getDerivInstrmAttrbts()).map(f->f.build()).orElse(null);
			this.finInstrmGnlAttrbts = ofNullable(builder.getFinInstrmGnlAttrbts()).map(f->f.build()).orElse(null);
			this.id = builder.getId();
			this.schmeNm = ofNullable(builder.getSchmeNm()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public DerivInstrmAttrbts getDerivInstrmAttrbts() {
			return derivInstrmAttrbts;
		}
		
		@Override
		public FinInstrmGnlAttrbts getFinInstrmGnlAttrbts() {
			return finInstrmGnlAttrbts;
		}
		
		@Override
		public String getId() {
			return id;
		}
		
		@Override
		public SchmeNm getSchmeNm() {
			return schmeNm;
		}
		
		@Override
		public Othr build() {
			return this;
		}
		
		@Override
		public Othr.OthrBuilder toBuilder() {
			Othr.OthrBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Othr.OthrBuilder builder) {
			ofNullable(getDerivInstrmAttrbts()).ifPresent(builder::setDerivInstrmAttrbts);
			ofNullable(getFinInstrmGnlAttrbts()).ifPresent(builder::setFinInstrmGnlAttrbts);
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getSchmeNm()).ifPresent(builder::setSchmeNm);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Othr _that = getType().cast(o);
		
			if (!Objects.equals(derivInstrmAttrbts, _that.getDerivInstrmAttrbts())) return false;
			if (!Objects.equals(finInstrmGnlAttrbts, _that.getFinInstrmGnlAttrbts())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(schmeNm, _that.getSchmeNm())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (derivInstrmAttrbts != null ? derivInstrmAttrbts.hashCode() : 0);
			_result = 31 * _result + (finInstrmGnlAttrbts != null ? finInstrmGnlAttrbts.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (schmeNm != null ? schmeNm.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Othr {" +
				"derivInstrmAttrbts=" + this.derivInstrmAttrbts + ", " +
				"finInstrmGnlAttrbts=" + this.finInstrmGnlAttrbts + ", " +
				"id=" + this.id + ", " +
				"schmeNm=" + this.schmeNm +
			'}';
		}
	}
	
	//Othr.OthrBuilderImpl
	class OthrBuilderImpl implements Othr.OthrBuilder {
	
		protected DerivInstrmAttrbts.DerivInstrmAttrbtsBuilder derivInstrmAttrbts;
		protected FinInstrmGnlAttrbts.FinInstrmGnlAttrbtsBuilder finInstrmGnlAttrbts;
		protected String id;
		protected SchmeNm.SchmeNmBuilder schmeNm;
	
		public OthrBuilderImpl() {
		}
	
		@Override
		public DerivInstrmAttrbts.DerivInstrmAttrbtsBuilder getDerivInstrmAttrbts() {
			return derivInstrmAttrbts;
		}
		
		@Override
		public DerivInstrmAttrbts.DerivInstrmAttrbtsBuilder getOrCreateDerivInstrmAttrbts() {
			DerivInstrmAttrbts.DerivInstrmAttrbtsBuilder result;
			if (derivInstrmAttrbts!=null) {
				result = derivInstrmAttrbts;
			}
			else {
				result = derivInstrmAttrbts = DerivInstrmAttrbts.builder();
			}
			
			return result;
		}
		
		@Override
		public FinInstrmGnlAttrbts.FinInstrmGnlAttrbtsBuilder getFinInstrmGnlAttrbts() {
			return finInstrmGnlAttrbts;
		}
		
		@Override
		public FinInstrmGnlAttrbts.FinInstrmGnlAttrbtsBuilder getOrCreateFinInstrmGnlAttrbts() {
			FinInstrmGnlAttrbts.FinInstrmGnlAttrbtsBuilder result;
			if (finInstrmGnlAttrbts!=null) {
				result = finInstrmGnlAttrbts;
			}
			else {
				result = finInstrmGnlAttrbts = FinInstrmGnlAttrbts.builder();
			}
			
			return result;
		}
		
		@Override
		public String getId() {
			return id;
		}
		
		@Override
		public SchmeNm.SchmeNmBuilder getSchmeNm() {
			return schmeNm;
		}
		
		@Override
		public SchmeNm.SchmeNmBuilder getOrCreateSchmeNm() {
			SchmeNm.SchmeNmBuilder result;
			if (schmeNm!=null) {
				result = schmeNm;
			}
			else {
				result = schmeNm = SchmeNm.builder();
			}
			
			return result;
		}
		
	
		@Override
		public Othr.OthrBuilder setDerivInstrmAttrbts(DerivInstrmAttrbts derivInstrmAttrbts) {
			this.derivInstrmAttrbts = derivInstrmAttrbts==null?null:derivInstrmAttrbts.toBuilder();
			return this;
		}
		@Override
		public Othr.OthrBuilder setFinInstrmGnlAttrbts(FinInstrmGnlAttrbts finInstrmGnlAttrbts) {
			this.finInstrmGnlAttrbts = finInstrmGnlAttrbts==null?null:finInstrmGnlAttrbts.toBuilder();
			return this;
		}
		@Override
		public Othr.OthrBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		public Othr.OthrBuilder setSchmeNm(SchmeNm schmeNm) {
			this.schmeNm = schmeNm==null?null:schmeNm.toBuilder();
			return this;
		}
		
		@Override
		public Othr build() {
			return new Othr.OthrImpl(this);
		}
		
		@Override
		public Othr.OthrBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Othr.OthrBuilder prune() {
			if (derivInstrmAttrbts!=null && !derivInstrmAttrbts.prune().hasData()) derivInstrmAttrbts = null;
			if (finInstrmGnlAttrbts!=null && !finInstrmGnlAttrbts.prune().hasData()) finInstrmGnlAttrbts = null;
			if (schmeNm!=null && !schmeNm.prune().hasData()) schmeNm = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDerivInstrmAttrbts()!=null && getDerivInstrmAttrbts().hasData()) return true;
			if (getFinInstrmGnlAttrbts()!=null && getFinInstrmGnlAttrbts().hasData()) return true;
			if (getId()!=null) return true;
			if (getSchmeNm()!=null && getSchmeNm().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Othr.OthrBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Othr.OthrBuilder o = (Othr.OthrBuilder) other;
			
			merger.mergeRosetta(getDerivInstrmAttrbts(), o.getDerivInstrmAttrbts(), this::setDerivInstrmAttrbts);
			merger.mergeRosetta(getFinInstrmGnlAttrbts(), o.getFinInstrmGnlAttrbts(), this::setFinInstrmGnlAttrbts);
			merger.mergeRosetta(getSchmeNm(), o.getSchmeNm(), this::setSchmeNm);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Othr _that = getType().cast(o);
		
			if (!Objects.equals(derivInstrmAttrbts, _that.getDerivInstrmAttrbts())) return false;
			if (!Objects.equals(finInstrmGnlAttrbts, _that.getFinInstrmGnlAttrbts())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(schmeNm, _that.getSchmeNm())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (derivInstrmAttrbts != null ? derivInstrmAttrbts.hashCode() : 0);
			_result = 31 * _result + (finInstrmGnlAttrbts != null ? finInstrmGnlAttrbts.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (schmeNm != null ? schmeNm.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OthrBuilder {" +
				"derivInstrmAttrbts=" + this.derivInstrmAttrbts + ", " +
				"finInstrmGnlAttrbts=" + this.finInstrmGnlAttrbts + ", " +
				"id=" + this.id + ", " +
				"schmeNm=" + this.schmeNm +
			'}';
		}
	}
}
