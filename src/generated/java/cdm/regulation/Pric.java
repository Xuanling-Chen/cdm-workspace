package cdm.regulation;

import cdm.regulation.meta.PricMeta;
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

public interface Pric extends RosettaModelObject {
	Pric build();
	Pric.PricBuilder toBuilder();
	
	/**
	 */
	String getBsisPts();
	/**
	 */
	Pric getPric();
	final static PricMeta metaData = new PricMeta();
	
	@Override
	default RosettaMetaData<? extends Pric> metaData() {
		return metaData;
	} 
			
	static Pric.PricBuilder builder() {
		return new Pric.PricBuilderImpl();
	}
	
	default Class<? extends Pric> getType() {
		return Pric.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("bsisPts"), String.class, getBsisPts(), this);
		
		processRosetta(path.newSubPath("pric"), processor, Pric.class, getPric());
	}
	
	
	interface PricBuilder extends Pric, RosettaModelObjectBuilder {
		Pric.PricBuilder getOrCreatePric();
		Pric.PricBuilder getPric();
		Pric.PricBuilder setBsisPts(String bsisPts);
		Pric.PricBuilder setPric(Pric pric);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("bsisPts"), String.class, getBsisPts(), this);
			
			processRosetta(path.newSubPath("pric"), processor, Pric.PricBuilder.class, getPric());
		}
		
	}
	
	//Pric.PricImpl
	class PricImpl implements Pric {
		private final String bsisPts;
		private final Pric pric;
		
		protected PricImpl(Pric.PricBuilder builder) {
			this.bsisPts = builder.getBsisPts();
			this.pric = ofNullable(builder.getPric()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public String getBsisPts() {
			return bsisPts;
		}
		
		@Override
		public Pric getPric() {
			return pric;
		}
		
		@Override
		public Pric build() {
			return this;
		}
		
		@Override
		public Pric.PricBuilder toBuilder() {
			Pric.PricBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Pric.PricBuilder builder) {
			ofNullable(getBsisPts()).ifPresent(builder::setBsisPts);
			ofNullable(getPric()).ifPresent(builder::setPric);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Pric _that = getType().cast(o);
		
			if (!Objects.equals(bsisPts, _that.getBsisPts())) return false;
			if (!Objects.equals(pric, _that.getPric())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (bsisPts != null ? bsisPts.hashCode() : 0);
			_result = 31 * _result + (pric != null ? pric.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Pric {" +
				"bsisPts=" + this.bsisPts + ", " +
				"pric=" + this.pric +
			'}';
		}
	}
	
	//Pric.PricBuilderImpl
	class PricBuilderImpl implements Pric.PricBuilder {
	
		protected String bsisPts;
		protected Pric.PricBuilder pric;
	
		public PricBuilderImpl() {
		}
	
		@Override
		public String getBsisPts() {
			return bsisPts;
		}
		
		@Override
		public Pric.PricBuilder getPric() {
			return pric;
		}
		
		@Override
		public Pric.PricBuilder getOrCreatePric() {
			Pric.PricBuilder result;
			if (pric!=null) {
				result = pric;
			}
			else {
				result = pric = Pric.builder();
			}
			
			return result;
		}
		
	
		@Override
		public Pric.PricBuilder setBsisPts(String bsisPts) {
			this.bsisPts = bsisPts==null?null:bsisPts;
			return this;
		}
		@Override
		public Pric.PricBuilder setPric(Pric pric) {
			this.pric = pric==null?null:pric.toBuilder();
			return this;
		}
		
		@Override
		public Pric build() {
			return new Pric.PricImpl(this);
		}
		
		@Override
		public Pric.PricBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Pric.PricBuilder prune() {
			if (pric!=null && !pric.prune().hasData()) pric = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBsisPts()!=null) return true;
			if (getPric()!=null && getPric().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Pric.PricBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Pric.PricBuilder o = (Pric.PricBuilder) other;
			
			merger.mergeRosetta(getPric(), o.getPric(), this::setPric);
			
			merger.mergeBasic(getBsisPts(), o.getBsisPts(), this::setBsisPts);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Pric _that = getType().cast(o);
		
			if (!Objects.equals(bsisPts, _that.getBsisPts())) return false;
			if (!Objects.equals(pric, _that.getPric())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (bsisPts != null ? bsisPts.hashCode() : 0);
			_result = 31 * _result + (pric != null ? pric.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PricBuilder {" +
				"bsisPts=" + this.bsisPts + ", " +
				"pric=" + this.pric +
			'}';
		}
	}
}
